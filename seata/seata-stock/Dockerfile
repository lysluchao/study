# Base image
FROM openjdk:8-jdk-alpine

# Copy the Spring Boot application to the container
WORKDIR /app
COPY target/*.jar app.jar

# Expose the Spring Boot application port
EXPOSE 6581

# Entrypoint
CMD ["java", "-jar", "app.jar"]