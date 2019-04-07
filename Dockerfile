FROM frolvlad/alpine-oraclejre8
MAINTAINER Wagner Jeronimo <wagner@meuportaretrato.com>
VOLUME /tmp
ADD target/notification.jar notification.jar
RUN sh -c 'touch /notification.jar'
ENV JAVA_OPTS="-Duser.timezone=America/Sao_Paulo -Xms64m -Xmx128m"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -Dspring.profiles.active=$profile -Djava.security.egd=file:/dev/./urandom -jar /notification.jar" ]