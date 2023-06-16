# Usar a imagem base do OpenJDK 11
FROM openjdk:11-jre-slim

# Copiar o arquivo JAR da aplicação para o diretório /app
COPY target/fastfood-api.jar /app/fastfood-api.jar

# Definir o comando de entrada para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "/app/fastfood-api.jar"]
