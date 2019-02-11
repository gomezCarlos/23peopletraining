FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENV SPRING_PROFILES_ACTIVE docker
ENV SPRING_CLOUD_CONFIG_URI http://192.168.0.154:8888/
ENV SERVICE_URL_DEFAULT_ZONE http://192.168.0.154:8761/eureka/
ENTRYPOINT ["java","-jar","/app.jar"]
