package com.experiments.book.config;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Objects;

@TestConfiguration
public class ComponentTestConfig {

    private static EmbeddedPostgres embeddedPostgres;

    @Bean
    TestRestTemplate testRestTemplate(){
        return new TestRestTemplate();
    }

    @Profile("test")
    @PostConstruct
    @Bean(name = "embeddedPostgresDataSource")
    public DataSource embeddedPostgres() throws IOException {
        if(Objects.isNull(embeddedPostgres )){
            embeddedPostgres = EmbeddedPostgres.builder().start();
        }
        //Setting the port number at runtime.
        System.setProperty("DB_PORT", embeddedPostgres.getPort() + "");
        return embeddedPostgres.getPostgresDatabase();
    }
}
