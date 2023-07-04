# Usar a imagem base do OpenJDK 11
FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package

FROM openjdk:17-slim

COPY --from=build /app/target/*.jar /usr/local/lib/app.jar

ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]