
FROM maven:3.9-eclipse-temurin-25 AS build

WORKDIR /app

COPY backend/pom.xml ./pom.xml
COPY backend/src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:25-jre

WORKDIR /app

COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 10000

CMD ["sh", "-c", "java -Dserver.port=${PORT:-10000} -jar app.jar"]
