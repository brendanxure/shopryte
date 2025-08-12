# ------------------------------
# Stage 1: Build with Maven
# ------------------------------
FROM eclipse-temurin:21-jdk-alpine AS build

# Install Maven
RUN apk add --no-cache maven

# Set working directory
WORKDIR /app

# Copy Maven descriptor and download dependencies first (better caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build application (skip tests for faster builds)
RUN mvn clean package -DskipTests -Dmaven.compiler.failOnError=false

# ------------------------------
# Stage 2: Runtime image
# ------------------------------
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy built JAR from build stage
COPY --from=build /app/target/xurepify-0.0.1-SNAPSHOT.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

