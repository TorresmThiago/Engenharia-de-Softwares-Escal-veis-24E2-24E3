FROM openjdk:17-jdk-slim
LABEL authors="torres"
WORKDIR /app
COPY target/nota-fiscal-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]