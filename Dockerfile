FROM amazoncorretto:11-alpine-jdk
RUN mkdir /app
WORKDIR /app
MAINTAINER MARTIN
COPY deploy/portfolio-1.jar /app/portfolio-1.jar
ENTRYPOINT ["java","-jar","/porfolio-app.jar"]