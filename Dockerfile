# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Copy the Spring Boot JAR into the image
ARG JAR_FILE=onlinedelivery-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar


# Start the app only after MySQL is up
COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh

ENTRYPOINT ["./wait-for-it.sh", "mysql:3306", "--", "java", "-jar", "app.jar"]