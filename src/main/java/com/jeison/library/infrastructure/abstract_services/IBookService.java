package com.jeison.library.infrastructure.abstract_services;

import java.util.List;

import com.jeison.library.api.dto.request.BookReq;
import com.jeison.library.api.dto.response.BookResp;
import com.jeison.library.api.dto.response.BookRespWithDetails;

public interface IBookService extends CrudService<BookReq,BookReq,BookResp,BookRespWithDetails,Long>,findAllService<BookResp,Long>{

    public final String FIELD_BY_SORT = "title";
    public List<BookResp> filterBooks(String title,String author,String genre);

}
