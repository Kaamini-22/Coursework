FROM openjdk:latest
COPY ./target/classes/Code1 /tmp/Code1
COPY ./target/classes/com/napier/sem /tmp/com/napier/sem
WORKDIR /tmp
ENTRYPOINT ["java", "Code1.Intro"]
