# Use Eclipse Temurin JDK 25 (early access)
FROM eclipse-temurin:25-jdk

# Set working directory
WORKDIR /app

# Copy your Spring Boot jar
COPY target/*.jar parking-0.0.1-SNAPSHOT

# Expose the Spring Boot port
EXPOSE 8083

# Run the application
ENTRYPOINT ["java", "-jar", "parking-0.0.1-SNAPSHOT"]
