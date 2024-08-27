FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/tp2-app-0.0.1-SNAPSHOT.jar tp2-app.jar

EXPOSE 8080



ENTRYPOINT ["java", "-jar", "tp2-app.jar"]

