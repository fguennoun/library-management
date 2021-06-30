FROM openjdk:11-ea-11-slim
EXPOSE 8080
ADD target/library-management.jar library-management.jar
ENTRYPOINT ["java", "-jar", "library-management.jar"]
