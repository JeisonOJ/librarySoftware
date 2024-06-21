package com.jeison.library.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.jeison.library.api.dto.request.BookReq;
import com.jeison.library.api.dto.response.BookResp;
import com.jeison.library.api.dto.response.BookRespWithDetails;
import com.jeison.library.domain.entities.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {

    Book reqToEntity(BookReq bookReq);

    BookResp EntityToResp(Book book);

    BookRespWithDetails EntityToRespComp(Book book);

}
