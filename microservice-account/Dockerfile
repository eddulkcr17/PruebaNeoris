FROM openjdk:17
VOLUME /tmp
EXPOSE 8091
ARG JAR_FILE=target/prueba-neoris-1.0.0.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]