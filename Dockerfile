FROM adoptopenjdk/openjdk11
ADD target/spring-postgres-docker-0.01-SNAPSHOT.jar app.jar
MAINTAINER Alsahid Simms<github:simms11>