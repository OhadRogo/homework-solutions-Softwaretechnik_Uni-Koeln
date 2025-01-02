#FROM ubuntu:latest
#LABEL authors="ohadragolsky"

#ENTRYPOINT ["top", "-b"]

# Start with the official Java image
FROM openjdk:23-jdk

# Set the working directory in the Docker container
WORKDIR /app

# Copy the JAR file into the Docker container
COPY target/homework_7-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot application runs on
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
