# Step 1: Use official Eclipse Temurin (OpenJDK) image
FROM eclipse-temurin:21-jdk

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy JAR from target folder
COPY target/StudentCRUDBackend-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose port
EXPOSE 8080

# Step 5: Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
