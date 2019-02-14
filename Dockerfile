FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENV SPRING_PROFILES_ACTIVE docker
#ENV SERVICE_URL_DEFAULT_ZONE http://eureka-server:8761/eureka/
ENTRYPOINT ["java","-jar","/app.jar"]
