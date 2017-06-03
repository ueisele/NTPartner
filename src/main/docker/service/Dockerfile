FROM openjdk:8-jre

EXPOSE 8081

WORKDIR /app
COPY *-exec.jar /app/ntpartner-backend-exec.jar

CMD ["java", "-jar", "-Dspring.profiles.active=local", "/app/ntpartner-backend-exec.jar"]

ARG VERSION
LABEL de.nt.cloud.group="ntpartner" de.nt.cloud.name="ntpartner-backend" de.nt.cloud.version="${VERSION}"