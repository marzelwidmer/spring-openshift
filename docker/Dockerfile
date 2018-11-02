FROM openjdk:8-jre-alpine
VOLUME /tmp

ARG JAR_FILE
COPY $JAR_FILE app.jar
RUN sh -c 'touch /app.jar'

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    SLEEP=0 \
    JAVA_OPTS="" \
    SPRING_PROFILE=""

CMD echo "The application will start in ${SLEEP}s..." && \
    sleep ${SLEEP}

ENTRYPOINT exec java $JAVA_OPTS \
     -Djava.security.egd=file:/dev/./urandom \
     -Dspring.profiles.active=$SPRING_PROFILE \
     -jar app.jar

