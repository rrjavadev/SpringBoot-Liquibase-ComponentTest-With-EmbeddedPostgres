package com.experiments.book.service;

import com.experiments.book.dto.BookDto;
import com.experiments.book.mapper.BookDtoMapper;
import com.experiments.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueServiceImpl implements CatalogueService{

    private  final BookRepository bookRepository;
    private final BookDtoMapper bookDtoMapper;

    public CatalogueServiceImpl(BookRepository bookRepository, BookDtoMapper bookDtoMapper){
        this.bookRepository = bookRepository;
        this.bookDtoMapper = bookDtoMapper;
    }

    public List<BookDto> getBooks(){
        return bookDtoMapper.toBookDtos(bookRepository.findAll());
    }
}
