FROM openjdk:17-oracle
EXPOSE 8080
ADD web/target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]