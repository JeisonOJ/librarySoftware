package com.jeison.library.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeison.library.api.dto.request.BookReq;
import com.jeison.library.api.dto.response.BookResp;
import com.jeison.library.api.dto.response.BookRespWithDetails;
import com.jeison.library.domain.entities.Book;
import com.jeison.library.domain.repositories.BookRepository;
import com.jeison.library.infrastructure.abstract_services.IBookService;
import com.jeison.library.infrastructure.mapper.BookMapper;
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
}
