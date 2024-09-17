FROM openjdk:17-jdk-slim
LABEL authors="torres"
WORKDIR /app
COPY target/eureka-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]