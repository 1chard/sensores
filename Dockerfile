
FROM maven
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests
CMD ["java", "-jar", "target/sensores-0.0.1-SNAPSHOT.jar"]