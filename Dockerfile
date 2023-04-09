FROM eclipse-temurin:17-jre-alpine

VOLUME /tmp
WORKDIR "/"
ARG JAR_FILE
ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Duser.timezone=Asia/Taipei","/app.jar"]