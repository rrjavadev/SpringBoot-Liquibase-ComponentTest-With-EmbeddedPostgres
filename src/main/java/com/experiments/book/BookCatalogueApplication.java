package com.experiments.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.experiments")
public class BookCatalogueApplication {
    public static void main(String[] args){
        SpringApplication.run(BookCatalogueApplication.class, args);
    }
}
