FROM openjdk:17-jdk

WORKDIR /app
COPY ./target/customerManagementSystem-0.0.1-SNAPSHOT.jar customerManagementSystem.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "customerManagementSystem.jar"]