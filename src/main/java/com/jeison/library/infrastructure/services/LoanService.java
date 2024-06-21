package com.jeison.library.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeison.library.api.dto.request.LoanReq;
import com.jeison.library.api.dto.request.LoanReqToUpdate;
import com.jeison.library.api.dto.response.LoanRespWithDetails;
import com.jeison.library.domain.entities.Loan;
import com.jeison.library.domain.repositories.LoanRepository;
import com.jeison.library.infrastructure.abstract_services.ILoanService;
import com.jeison.library.infrastructure.mapper.LoanMapper;
import com.jeison.library.utils.exceptions.BadRequestException;
import com.jeison.library.utils.messages.ErrorMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanService implements ILoanService{

    @Autowired
    private final LoanRepository loanRepository;
    @Autowired
    private final LoanMapper loanMapper;

    @Override
    public LoanRespWithDetails findById(Long id) {
        return loanMapper.entityToRespComp(getById(id));
        
    }
    @Override
    public LoanRespWithDetails create(LoanReq request) {
        return loanMapper.entityToRespComp(loanRepository.save(loanMapper.reqToEntity(request)));

    }
    @Override
    public LoanRespWithDetails update(LoanReqToUpdate request, Long id) {
        Loan loan = getById(id);
        loanMapper.updateEntityFromReq(request,loan);
        return loanMapper.entityToRespComp(loanRepository.save(loan));
    }
    @Override
    public void delete(Long id) {
        loanRepository.delete(getById(id));

    }

    private Loan getById(Long id) {
        return loanRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("loan")));
    }

}
