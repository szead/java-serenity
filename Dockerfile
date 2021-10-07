FROM openjdk:17-jdk

ENV APP_HOME "/usr/src/app"
WORKDIR ${APP_HOME}

COPY gradle ${APP_HOME}/gradle/
COPY src ${APP_HOME}/src/
COPY build.gradle gradlew ${APP_HOME}/

RUN ./gradlew build -x test
