FROM blinfo/maven:3.6.1-jdk-11 as resolve
WORKDIR /backend
COPY pom.xml .
RUN mvn -e -B dependency:resolve

FROM resolve as build
COPY src ./src
RUN mvn -e -B package -DskipTests

FROM build as test
RUN mvn -e -B test

FROM openjdk:11.0.4-jre as release
WORKDIR /backend
RUN echo "Europe/Stockholm" > /etc/timezone && \
    ln -sf /usr/share/zoneinfo/Europe/Stockholm /etc/localtime && \
    dpkg-reconfigure -f noninteractive tzdata
COPY --from=test /backend/target/idempotent-filter.jar .
EXPOSE 8080
CMD ["java", "-jar", "idempotent-filter.jar"]
