FROM eclipse-temurin:11-jdk-jammy as builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY ./src ./src
RUN ./mvnw clean install
 
FROM eclipse-temurin:11-jre-jammy
WORKDIR /opt/app
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]
