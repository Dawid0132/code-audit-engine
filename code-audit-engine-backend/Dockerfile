FROM maven:3.9.3-eclipse-temurin-21 AS dependencies

WORKDIR /app
COPY pom.xml .
COPY GithubConnector/pom.xml GithubConnector/pom.xml
COPY GithubConnectorService/pom.xml GithubConnectorService/pom.xml

RUN mvn -B -e org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline -DexcludeArtifactIds=domain

FROM maven:3.9.4-eclipse-temurin-21 AS builder

WORKDIR /app
COPY --from=dependencies /root/.m2 /root/.m2
COPY . .

RUN mvn -B -e clean install -DskipTests

FROM eclipse-temurin:21-jdk as github-conector

WORKDIR /app

COPY --from=builder /app/GithubConnector/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]

FROM eclipse-temurin:21-jdk as github-conector-service

WORKDIR /app

COPY --from=builder /app/GithubConnectorService/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","app.jar"]