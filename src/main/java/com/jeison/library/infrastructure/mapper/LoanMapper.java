package com.jeison.library.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.jeison.library.api.dto.request.LoanReq;
import com.jeison.library.api.dto.request.LoanReqToUpdate;
import com.jeison.library.api.dto.response.LoanResp;
import com.jeison.library.api.dto.response.LoanRespWithDetails;
import com.jeison.library.domain.entities.Loan;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanMapper {

    Loan reqToEntity(LoanReq loanReq);

    Loan reqToEntityToUpdate(LoanReqToUpdate loanReqToUpdate);

    @Mappings({
            @Mapping(source = "loanDate", target = "loanDate", dateFormat = "yyyy-MM-dd HH-mm-ss"),
            @Mapping(source = "returnDate", target = "returnDate", dateFormat = "yyyy-MM-dd HH-mm-ss")
    })
    LoanResp EntityToResp(Loan loan);

    @Mappings({
            @Mapping(source = "loanDate", target = "loanDate", dateFormat = "yyyy-MM-dd HH-mm-ss"),
            @Mapping(source = "returnDate", target = "returnDate", dateFormat = "yyyy-MM-dd HH-mm-ss")
    })
    LoanRespWithDetails EntityToRespComp(Loan loan);

}
