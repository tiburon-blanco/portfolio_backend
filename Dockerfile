FROM ibm-semeru-runtimes:open-11-jre-focal
RUN mkdir /app
WORKDIR /app
MAINTAINER https://renanfranca.github.io/about.html
COPY build/libs/portfolio-1.jar /app/portfolio-1.jar
ENV _JAVA_OPTIONS="-XX:MaxRAM=70m"
CMD java $JAVA_OPTS -Djava.security.egd=file:/dev/./randon -jar portfolio-1.jar