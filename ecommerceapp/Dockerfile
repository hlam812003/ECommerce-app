FROM maven:3.9.5-eclipse-temurin-21 AS webapp

COPY pom.xml /tmp/
COPY src /tmp/src
WORKDIR /tmp/
RUN mvn package -DskipTests

FROM tomcat:10.1.16-jdk21
COPY --from=webapp /tmp/target/*.war /usr/local/tomcat/webapps/ROOT.war


EXPOSE 8080

ENTRYPOINT []

CMD ["catalina.sh", "run"]