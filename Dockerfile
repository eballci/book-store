FROM openjdk:17-alpine
ADD target/build.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]