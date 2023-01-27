# Summary
This is a backend PlanningCenter integration using Spring Boot to easily pull Planning Center data into your application such as a mobile app, website, or web application!
It utilizes the following technologies:
- **Java 17**: latest stable version of Java
- **Gradle**: dependency management
- **Spring-Boot**: Spring framework with autoconfiguration
- **Spring-Reactive**: Reactive Web Framework
- **Spring-Native**: Utilizes Graalvm for a smaller resource imprint, pre-compilation and faster startup
- **Spring-Data**: 
- **Lombok**: auto-generates getters, setters, constructors, builders, equals, etc methods
- **Docker**: containerization
- **Postgres**: database technology that will run in a docker container


## Quick Start
1. Create a `.env` file in the project with the below values (using your information)
```
    PLANNING_CENTER_APPLICATION_ID=YOUR_PLANNING_CENTER_APPLICATION_ID_HERE
    PLANNING_CENTER_SECRET=YOUR_PLANNING_CENTER_SECRET_HERE
    PLANNING_CENTER_URL=https://api.planningcenteronline.com
    SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/compose-postgres
    SPRING_DATASOURCE_USERNAME=compose-postgres
    SPRING_DATASOURCE_PASSWORD=compose-postgres
    PGADMIN_EMAIL=admin@admin.com
    SPRING_PROFILES_ACTIVE=local
```
2. Build the GraalVM image: `gradle bootBuildImage`
3. Start the application using the created image: `docker-compose -f docker-compose-full.yml up -d`

## Swagger / Spring-Doc
Access local Swagger UI for API via http://localhost:8080/webjars/swagger-ui/index.html

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.2/gradle-plugin/reference/html/#build-image)
* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/docs/3.0.2/reference/html/native-image.html#native-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#appendix.configuration-metadata.annotation-processor)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#howto.data-initialization.migration-tool.flyway)
* [Resilience4J](https://docs.spring.io/spring-cloud-circuitbreaker/docs/current/reference/html/#configuring-resilience4j-circuit-breakers)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#using.devtools)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#web.reactive)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [Configure AOT settings in Build Plugin](https://docs.spring.io/spring-boot/docs/3.0.2/gradle-plugin/reference/htmlsingle/#aot)

## GraalVM Native Support

This project has been configured to let you generate either a lightweight container or a native executable.
It is also possible to run your tests in a native image.

### Lightweight Container with Cloud Native Buildpacks
If you're already familiar with Spring Boot container images support, this is the easiest way to get started.
Docker should be installed and configured on your machine prior to creating the image.

To create the image, run the following goal:

```
$ ./gradlew bootBuildImage
```

Then, you can run the app like any other container:

```
$ docker run --rm planning-center-integration:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools
Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM `native-image` compiler should be installed and configured on your machine.

NOTE: GraalVM 22.3+ is required.

To create the executable, run the following goal:

```
$ ./gradlew nativeCompile
```

Then, you can run the app as follows:
```
$ build/native/nativeCompile/planning-center-integration
```

You can also run your existing tests suite in a native image.
This is an efficient way to validate the compatibility of your application.

To run your existing tests in a native image, run the following goal:

```
$ ./gradlew nativeTest
```

