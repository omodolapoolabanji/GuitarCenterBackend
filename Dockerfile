FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/GuitarCenter-0.0.1-SNAPSHOT.jar guitarcenter.jar
ENTRYPOINT ["java", "-jar", "guitarcenter.jar"]