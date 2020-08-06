package com.experiments.book.component.test.helpers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

public class TestDatabaseHelper {

    private TestDatabaseHelper(){}

    public static void executeDBQuery(DataSource dataSource, String filePath) {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource(filePath));
        populator.execute(dataSource);
    }
}
