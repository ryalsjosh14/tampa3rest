# FROM openjdk:11
# COPY target/tampa3rest-0.0.1-SNAPSHOT.jar app.jar
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "/app.jar"]
#
#

#Copied from: https://github.com/nicktodd/jenkinsopenshiftspringdatabase/blob/master/Dockerfile
FROM maven:3.6.3-openjdk-11 AS compile
COPY . /usr/src/mymaven
WORKDIR /usr/src/mymaven
RUN mvn -Dmaven.test.skip=true clean package



FROM openjdk:11
RUN wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java_8.0.24-1debian9_all.deb -O /tmp/mysql-connector.deb
RUN dpkg -i /tmp/mysql-connector.deb
COPY --from=compile /usr/src/mymaven/target/tampa3rest-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/application-docker.properties application.properties
EXPOSE 8080
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/urandom -jar /app.jar" ]
#End of copy
