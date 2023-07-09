FROM amazoncorretto:17.0.7-alpine
COPY "./target/reservas-app-0.0.1-SNAPSHOT.war" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
