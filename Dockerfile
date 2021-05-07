FROM maven:3.6.1-jdk-11-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml clean package

FROM openjdk:11.0-slim
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 3000
ENTRYPOINT ["java","-jar","app.jar"]

## Use official base image of Java Runtim
#FROM openjdk:11.0-slim

###WORKDIR /usr/src/app/


###COPY BACKENDV2/ /usr/src/app/

# #Set volume point to /tmp

#VOLUME /tmp

## Make port 3000 available to the world outside container
#EXPOSE 3000

## Set application's JAR file
#ARG JAR_FILE=target/project-0.0.1-SNAPSHOT.jar

# #Add the application's JAR file to the container
#ADD ${JAR_FILE} app.jar

## Run the JAR file
#ENTRYPOINT ["java", "-jar", "/app.jar"]
