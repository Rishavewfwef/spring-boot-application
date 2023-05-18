FROM openjdk:17-alpine

COPY . /app
WORKDIR /app

ENTRYPOINT ["java", "-jar", "target/app.jar"]