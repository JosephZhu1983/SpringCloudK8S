FROM openjdk:8-jdk-slim
VOLUME /tmp
ADD k8sdemo.jar app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar