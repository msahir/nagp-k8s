FROM openjdk:8
EXPOSE 8080
ADD target/nagp-k8s.jar nagp-k8s.jar
ENTRYPOINT ["java","-jar","/nagp-k8s.jar"]