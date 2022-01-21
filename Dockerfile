FROM 894427396428.dkr.ecr.us-east-1.amazonaws.com/innolab-openjdk:Dev AS build

COPY /app/src/ /app/src/
COPY /app/mvnw /app/
COPY /app/.mvn /app/.mvn/
COPY /app/pom.xml /app/
WORKDIR /app/
RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM 894427396428.dkr.ecr.us-east-1.amazonaws.com/innolab-openjdk:Dev
RUN apk update && apk add bash
COPY --from=build /app/target/dependency/BOOT-INF/lib /app/lib
COPY --from=build /app/target/dependency/META-INF /app/META-INF
COPY --from=build /app/target/dependency/BOOT-INF/classes /app
COPY /scripts/docker/entrypoint/entrypoint.sh /scripts/entrypoint.sh
COPY /scripts/util/wait-for-it /scripts/wait-for-it
ENV PATH=/scripts/:${PATH}
ENTRYPOINT [ "entrypoint.sh" ]