package com.jeison.library.infrastructure.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.jeison.library.api.dto.request.LoanReq;
import com.jeison.library.api.dto.request.LoanReqToUpdate;
import com.jeison.library.api.dto.response.LoanResp;
import com.jeison.library.api.dto.response.LoanRespWithBooks;
import com.jeison.library.api.dto.response.LoanRespWithDetails;
import com.jeison.library.domain.entities.Loan;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanMapper {

        Loan reqToEntity(LoanReq loanReq);

        void updateEntityFromReq(LoanReqToUpdate request, @MappingTarget Loan loan);

        LoanResp entityToResp(Loan loan);

        LoanRespWithDetails entityToRespComp(Loan loan);
        LoanRespWithBooks entityToRespBooks(Loan loan);

        List<LoanResp> entityToList(List<Loan> loanList);

}
