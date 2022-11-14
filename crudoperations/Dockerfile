FROM ubuntu:22.04

RUN apt-get update

RUN apt-get install maven -y

RUN apt install openjdk-17-jdk -y

RUN apt install openjdk-17-jre -y

EXPOSE 8081

COPY ./target/docker-demo.jar docker-demo.jar

CMD ["java" , "-jar" , "docker-demo.jar"]