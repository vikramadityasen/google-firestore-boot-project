FROM java:8
EXPOSE 8081
ADD /target/firebase-0.0.1-SNAPSHOT.jar firebase.jar
VOLUME /tmp
ENTRYPOINT ["java","-jar","firebase.jar"]