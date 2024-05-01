FROM openjdk:21
LABEL authors="chaal"
WORKDIR /app
COPY ./target/SPILabb1-1.0-SNAPSHOT.jar /app/
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "SPILabb1-1.0-SNAPSHOT.jar"]