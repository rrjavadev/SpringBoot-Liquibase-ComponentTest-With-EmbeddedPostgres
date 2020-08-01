package com.experiments.book.controller;

import com.experiments.book.dto.BookDto;
import com.experiments.book.service.CatalogueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatalogueController {

    private final CatalogueService catalogueService;

    public CatalogueController(CatalogueService catalogueService){
        this.catalogueService = catalogueService;
    }

    @GetMapping("/books/{author}")
    public List<BookDto> getBooks(@PathVariable("author") String author){
        return catalogueService.getBooks(author);
    }
}
