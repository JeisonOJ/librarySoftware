package com.jeison.library.infrastructure.abstract_services;

import com.jeison.library.api.dto.request.LoanReq;
import com.jeison.library.api.dto.request.LoanReqToUpdate;
import com.jeison.library.api.dto.response.LoanRespWithDetails;

public interface ILoanService extends CrudService<LoanReq,LoanReqToUpdate,LoanRespWithDetails,LoanRespWithDetails,Long>{

}
