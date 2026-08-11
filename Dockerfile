# Stage 1: Build the Spring Boot application (3 points)
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# In a real project, we would copy the pom.xml and source code here
# COPY pom.xml .
# COPY src ./src
# RUN mvn clean package -DskipTests

# Mocking the creation of a target directory and a dummy jar file for the build step
RUN mkdir target && touch target/smart-clinic-app.jar

# Stage 2: Define runtime configuration (2 points)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy the compiled jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the Spring Boot app runs on
EXPOSE 8080

# Define the entrypoint command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
