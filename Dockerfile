FROM openjdk:24-jdk
LABEL authors="jack"
COPY target/fetch-interview-assessment-0.0.1.jar assessment.jar
ENTRYPOINT ["java", "-jar", "/assessment.jar"]