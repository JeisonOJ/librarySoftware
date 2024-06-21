package com.jeison.library.infrastructure.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.jeison.library.api.dto.request.BookReq;
import com.jeison.library.api.dto.response.BookResp;
import com.jeison.library.api.dto.response.BookRespWithDetails;
import com.jeison.library.domain.entities.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = { LoanMapper.class, ReservationMapper.class })
public interface BookMapper {

    Book reqToEntity(BookReq bookReq);

    void updateEntityFromReq(BookReq request, @MappingTarget Book book);

    BookResp entityToResp(Book book);

    BookRespWithDetails entityToRespComp(Book book);

    List<BookResp> entityToList(List<Book> bookList);

}
