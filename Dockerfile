FROM openjdk:11-jdk-alphine AS build

COPY /app/src/ /app/src/
COPY /app/mvnw /app/
COPY /app/.mvn /app/
COPY /app/pom.xml /app/
WORKDIR /app/
RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:8-jdk-alpine
RUN apt-get update -y && apt-get install -y wait-for-it
COPY --from=build /app/target/dependency/BOOT-INF/lib /app/lib
COPY --from=build /app/target/dependency/META-INF /app/META-INF
COPY --from=build /app/target/dependency/BOOT-INF/classes /app
COPY /scripts/docker/entrypoint/entrypoint.sh entrypoint.sh
ENTRYPOINT [ "entrypoint.sh" ]