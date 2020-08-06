package com.experiments.book.service;

import com.experiments.book.dto.BookDto;

import java.util.List;

public interface CatalogueService {
    List<BookDto> getBooks();
}
