package com.experiments.book.componet.test;

//import org.junit.Test;

import com.experiments.book.BookCatalogueApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {BookCatalogueApplication.class})
@ActiveProfiles("test")
public class BookCatalogueComponentTest {

    @Test
    public void TestMethod(){

    }
}
