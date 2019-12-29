FROM openjdk:8
ADD target/springbootdocker.war springbootdocker.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","springbootdocker.war"]