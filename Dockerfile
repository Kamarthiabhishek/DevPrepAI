FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/DevPrepAI-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","DevPrepAI-0.0.1-SNAPSHOT.jar"]