FROM openjdk:17-jdk-slim
LABEL authors="torres"
EXPOSE 8085
WORKDIR /app
COPY target/questao-05-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]