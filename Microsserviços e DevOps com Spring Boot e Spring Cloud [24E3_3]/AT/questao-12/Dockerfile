FROM openjdk:17-jdk-slim
LABEL authors="torres"
EXPOSE 8092
WORKDIR /app
COPY target/questao-12-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]