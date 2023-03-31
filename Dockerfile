FROM openjdk:latest
COPY ./target/classes/Code1 /tmp/Code1
WORKDIR /tmp
ENTRYPOINT ["java", "Code1.Intro"]
RUN ["java", "com/napier/sem/App.class"]
