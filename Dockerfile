# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY . .

WORKDIR /app/bankingApp
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app

COPY --from=build /app/bankingApp/target/*.jar app.jar

EXPOSE 10000
CMD ["java","-jar","app.jar"]