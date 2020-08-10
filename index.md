# Write component tests for SpringBoot application using Embdedded Postgres

I would like to share with you my experience on writing a component test for a Spring-boot application using embedded Postgres database. I am using Liquibase for database migration. A prior basic understanding of Spring Boot framework is expected from the reader.

### For this experiment, I am using:
* Spring-boot 2.3.1 RELEASE
* Liquibase for database migration
* PostgreSQL database for the application code
* [OpenTable embedded Postgres for the component test](https://github.com/opentable/otj-pg-embedded)
* Junit 5

The primary focus of this article is to help those poor souls who are in search of a simple and useful article about writing component tests using embedded Postgres database that runs against Liquibase. I have used H2 database previously but wasn't very happy with the outcome since I had some unpleasant experiences of the tests passing, but the DB migration failing whilst running the migration scripts against a real database. The use of PostgreSQL Test container is another option. Although this is a great approach, sometimes you may be constrained to only use an in-memory option, in case your client/employer is using an operating system that is not very Docker friendly. Believe me, this is 2020 and there are companies who are still using Windows 7 operating system!

### Architecture diagram

![architecture](/architecture.png)

#### Architecture diagram explained


### How this works?

1. As my first step, I have created a SpringBoot application called BookCatalogueApplication that uses PostgreSQL database in the backend. I have used Liquibase to do the database migration. The application has a GET /books endpoint, which returns the list of books to the consumers.
2. I have added otj-pg-embedded dependency to pom.xml so that I could use embedded postgres database in my component tests.

```xml
                <dependency>
                    <groupId>com.opentable.components</groupId>
                    <artifactId>otj-pg-embedded</artifactId>
                    <version>0.13.1</version>
                    <scope>test</scope>
                </dependency>
```
