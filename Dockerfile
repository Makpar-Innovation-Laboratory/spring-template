FROM openjdk:8-jdk-alpine AS build

COPY /app/src/ /app/src/
COPY /app/mvnw /app/
COPY /app/.mvn /app/.mvn/
COPY /app/pom.xml /app/
WORKDIR /app/
RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:8-jdk-alpine
RUN apk update -y && apk add -y bash
COPY --from=build /app/target/dependency/BOOT-INF/lib /app/lib
COPY --from=build /app/target/dependency/META-INF /app/META-INF
COPY --from=build /app/target/dependency/BOOT-INF/classes /app
COPY /scripts/docker/entrypoint/entrypoint.sh /scripts/entrypoint.sh
COPY /scripts/wait-for-it /scripts/wait-for-it
ENV PATH=/scripts/:${PATH}
ENTRYPOINT [ "entrypoint.sh" ]