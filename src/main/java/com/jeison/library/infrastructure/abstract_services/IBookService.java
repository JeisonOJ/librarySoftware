package com.jeison.library.infrastructure.abstract_services;

import com.jeison.library.api.dto.request.BookReq;
import com.jeison.library.api.dto.response.BookResp;
import com.jeison.library.api.dto.response.BookRespWithDetails;

public interface IBookService extends CrudService<BookReq,BookReq,BookResp,BookRespWithDetails,Long>{

}
