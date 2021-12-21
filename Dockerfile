FROM openjdk:11

RUN mkdir -p /app/
ADD target/SpringBoot-OpeFeign-Rest-Api-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 9999
ENTRYPOINT ["java","-Dspring.profiles.active=default", "-jar", "/app/app.jar"]