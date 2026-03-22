# Stage 1: Build
FROM eclipse-temurin:21-jdk-jammy AS builder
WORKDIR /app
# Copy only wrapper and config first (better caching)
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./
# Give execution permission
RUN chmod +x gradlew
# Copy source code
COPY src src
# Build using the WRAPPER instead of global gradle
RUN ./gradlew bootJar -x test

# Stage 2: Run
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
