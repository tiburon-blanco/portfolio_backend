FROM amazoncorretto:11-alpine-jdk
MAINTAINER MARTIN
COPY deploy/portfolio-1.jar portfolio-app.jar
ENTRYPOINT ["java","-jar","/porfolio-app.jar"]