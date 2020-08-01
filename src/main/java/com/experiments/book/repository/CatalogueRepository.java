package com.experiments.book.repository;

import com.experiments.book.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CatalogueRepository extends CrudRepository<Book, Long> {
    public List<Book> findByAuthorOrderByTitle(String author);
}
