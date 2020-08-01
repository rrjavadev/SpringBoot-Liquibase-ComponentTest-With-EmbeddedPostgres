package com.experiments.book.mapper;

import com.experiments.book.dto.BookDto;
import com.experiments.book.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy =  ReportingPolicy.ERROR)
public interface BookDtoMapper {

    BookDto toBookDto(Book book);

    List<BookDto> toBookDtos(List<Book> books);
}
