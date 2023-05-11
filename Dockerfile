FROM amazoncorretto:11-alpine-jdk
MAINTAINER MARTIN
COPY deploy/portfolio-1.jar portfolio-1.jar
ENTRYPOINT ["java","-jar","/porfolio-app.jar"]