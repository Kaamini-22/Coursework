FROM openjdk:latest
COPY ./target/CodeReview1-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "CodeReview1-0.1.0.1-jar-with-dependencies.jar"]
