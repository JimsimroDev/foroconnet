FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/foroconnet-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_foroconnet.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app_foroconnet.jar"]
