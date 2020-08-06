package com.experiments.book.component.test;

import com.experiments.book.BookCatalogueApplication;
import com.experiments.book.component.test.helpers.TestApiHelper;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

import static com.experiments.book.component.test.helpers.TestDatabaseHelper.executeDBQuery;
import static com.experiments.book.component.test.helpers.TestFileHelper.readFile;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest(classes = BookCatalogueApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@DirtiesContext
public class BookCatalogueComponentTest {

    private static final String INSERT_BOOKS = "db_queries/insert_books.sql";
    private static final String DELETE_BOOKS = "db_queries/delete_books.sql";
    private static final String GET_BOOKS = "/books";
    private static final String GET_BOOKS_RESPONSE = "response/get_books_response.json";

    @LocalServerPort
    private int applicationPort;

    @Autowired
    @Qualifier("embeddedPostgresDataSource")
    private DataSource dataSource;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        executeDBQuery(dataSource, DELETE_BOOKS);
        executeDBQuery(dataSource, INSERT_BOOKS);
    }

    @Test
    public void getBooks_ShouldReturnAListOfBooks() throws JSONException {

        //Given
        String expectedResponse = readFile(GET_BOOKS_RESPONSE);

        //When
        ResponseEntity<String> actualResponse = TestApiHelper.getForEntity(applicationPort, GET_BOOKS);

        //Then
        assertEquals(expectedResponse, actualResponse.getBody(), JSONCompareMode.STRICT);
    }
}
