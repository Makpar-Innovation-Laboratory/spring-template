# Spring Boot Template

This repo contains the code scaffolding to get started on a [Spring Boot application](https://spring.io/guides/gs/spring-boot/).

## Prerequisites

- [openjdk-8](https://openjdk.java.net/install/)
- [mvn](https://maven.apache.org/download.cgi)
- [docker](https://www.docker.com/products/docker-desktop)

## Setup

### Local

1. Compile the application in a *jar*. If you do not have `mvn` installed, you can use the maven wrapper in the */app/* directory,

```shell
cd app
./mvnw clean install
```

2. Use the *jar* to start up the application,

```shell
cd app/target
java -jar <jar-name>
```

**NOTE**: Running the application locally requires a **Postgres** connection. You will need to configure the **Postgres** */app/src/resources/application.properties* file. As an alternative to directly editing this file (it currently ingests environment variables to prevent credentials from being committed), it recommended you copy the *.sample.env* file into a new *.env* and configure the credentials there (the *.env* file is on the *.gitignore*),

```shell
cp .sample.env .env
```

These variables will need loaded into your current session. You can `source` *.env* and `export` them, i.e.,

```shell
source .env
export POSTGRES_HOST
export POSTGRES_PORT
# ...all the other variables Spring requires
```

However, this can be tedious. It is recommended, instead of manually compiling the jar and exporting the environment variables in your session, simply use the *start* script,

```shell
./scripts/start
```

This script will perform all the steps detailed above.

### Container

1. Build the Docker image,

```shell
docker build -t spring-template:latest .
```

2. Orchestrate the image with a **Postgres** container using the *docker-compose.yml*,

```shell
docker-compose up
```

## Gotchas

1. If you are on Windows, it is possible to spin up a **Postgres** container and expose it on port 5432 while a **Postgres** service is running locally on port 5432. This can leading to confusing errors. If you are getting authentication errors while trying to connect to the containerized database, see [psql: FATAL: password authentication failed](https://github.com/sameersbn/docker-postgresql/issues/112)