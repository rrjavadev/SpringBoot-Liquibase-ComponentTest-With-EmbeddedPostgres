package com.experiments.book.component.test.helpers;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TestApiHelper {

    private static TestRestTemplate restTemplate;

    public TestApiHelper(TestRestTemplate testRestTemplate) {
        this.restTemplate = testRestTemplate;
    }

    public static ResponseEntity<String> getForEntity(int port, String url) {
       return restTemplate.getForEntity(getUri(port, url), String.class);
    }

    private static String getUri(int port, String url){
        return "http://localhost:" + port + url;
    }
}
