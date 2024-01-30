FROM gradle:8.3.0-jdk17 AS build
COPY --chown=gradle:gradle . /src
WORKDIR /src
RUN gradle clean build --no-daemon

FROM openjdk:17-jdk-slim
WORKDIR /app
EXPOSE 8080
COPY --from=build /src/build/libs/*.jar /app/twitter-api.jar
ENTRYPOINT ["java","-jar","/app/twitter-api.jar"]