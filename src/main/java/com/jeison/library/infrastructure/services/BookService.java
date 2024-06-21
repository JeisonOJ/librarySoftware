package com.jeison.library.infrastructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jeison.library.api.dto.request.BookReq;
import com.jeison.library.api.dto.response.BookResp;
import com.jeison.library.api.dto.response.BookRespWithDetails;
import com.jeison.library.domain.entities.Book;
import com.jeison.library.domain.repositories.BookRepository;
import com.jeison.library.infrastructure.abstract_services.IBookService;
import com.jeison.library.infrastructure.mapper.BookMapper;
import com.jeison.library.utils.enums.SortType;
import com.jeison.library.utils.exceptions.BadRequestException;
import com.jeison.library.utils.messages.ErrorMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService implements IBookService {

    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final BookMapper bookMapper;

    @Override
    public BookRespWithDetails findById(Long id) {
        return bookMapper.entityToRespComp(getById(id));
    }

    @Override
    public BookResp create(BookReq request) {
        return bookMapper.entityToResp(bookRepository.save(bookMapper.reqToEntity(request)));
    }

    @Override
    public BookResp update(BookReq request, Long id) {
        Book book = getById(id);
        bookMapper.updateEntityFromReq(request, book);
        return bookMapper.entityToResp(bookRepository.save(book));
    }

    @Override
    public void delete(Long id) {
        bookRepository.delete(getById(id));

    }

    private Book getById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("book")));
    }

    @Override
    public Page<BookResp> findAll(int page, int size, SortType sortType) {
        if (page < 0)
            page = 0;

        PageRequest pageRequest = null;

        switch (sortType) {
            case NONE -> pageRequest = PageRequest.of(page, size);
            case ASC -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
            default -> throw new IllegalArgumentException("No valid sort: " + sortType);
        }

        Pageable pageable = pageRequest;
        return bookRepository.findAll(pageable).map(book -> bookMapper.entityToResp(book));
    }

    @Override
    public List<BookResp> filterBooks(String title, String author, String genre) {
        List<Book> books = bookRepository.findByTitleContainingAndAuthorContainingAndGenreContaining(title, author, genre);
        return bookMapper.entityToList(books);
    }
}
