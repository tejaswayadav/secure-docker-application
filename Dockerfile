FROM openjdk:8-jdk-alpine
MAINTAINER Tejaswa Yadav "tejaswayadav@gmail.com"
WORKDIR /usr/local/bin/
COPY /target/*.jar ./app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
