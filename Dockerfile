

FROM openjdk:11.0-slim
EXPOSE 3000
ENTRYPOINT ["java","-jar","app.jar"]
