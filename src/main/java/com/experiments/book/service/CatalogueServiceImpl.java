package com.experiments.book.service;

import com.experiments.book.dto.BookDto;
import com.experiments.book.mapper.BookDtoMapper;
import com.experiments.book.repository.CatalogueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueServiceImpl implements CatalogueService{

    private  final CatalogueRepository catalogueRepository;
    private final BookDtoMapper bookDtoMapper;

    public CatalogueServiceImpl(CatalogueRepository catalogueRepository, BookDtoMapper bookDtoMapper){
        this.catalogueRepository = catalogueRepository;
        this.bookDtoMapper = bookDtoMapper;
    }

    public List<BookDto> getBooks(String author){
        return bookDtoMapper.toBookDtos(catalogueRepository.findByAuthorOrderByTitle(author));
    }
}
