# Usar a imagem base do OpenJDK 11
FROM openjdk:17-jdk-slim

# Copiar o arquivo JAR da aplicação para o diretório /app
COPY target/fastfood-0.0.1-SNAPSHOT.jar /app/fastfood-api.jar

# Definir o comando de entrada para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "/app/fastfood-api.jar"]
