FROM amazoncorretto:11-alpine-jdk
MAINTAINER MARTIN
EXPOSE 8080
COPY deploy/portfolio-1.jar portfolio-app.jar
ENTRYPOINT ["java","-jar","/portfolio-app.jar"]