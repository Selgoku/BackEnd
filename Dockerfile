FROM amazoncorretto:11-alpine-jdk
MAINTAINER LaL
COPY target/lal-0.0.1-SNAPSHOT.jar lal-app.jar
ENTRYPOINT ["java","-jar","/lal-app.jar"]
