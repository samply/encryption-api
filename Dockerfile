FROM java:8-jre

RUN mkdir /working

ADD target/encryption-api-0.0.1-SNAPSHOT.jar /working/encryption-api-0.0.1-SNAPSHOT.jar

CMD java -jar /working/encryption-api-0.0.1-SNAPSHOT.jar

