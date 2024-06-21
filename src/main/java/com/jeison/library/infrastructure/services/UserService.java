package com.jeison.library.infrastructure.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeison.library.api.dto.request.UserReq;
import com.jeison.library.api.dto.request.UserReqToUpdate;
import com.jeison.library.api.dto.response.UserResp;
import com.jeison.library.api.dto.response.UserRespWithDetails;
import com.jeison.library.api.dto.response.UserRespWithLoansAndBooks;
import com.jeison.library.api.dto.response.UserRespWithReservationsAndBooks;
import com.jeison.library.domain.entities.User;
import com.jeison.library.domain.repositories.UserRepository;
import com.jeison.library.infrastructure.abstract_services.IUserService;
import com.jeison.library.infrastructure.mapper.UserMapper;
import com.jeison.library.utils.exceptions.BadRequestException;
import com.jeison.library.utils.messages.ErrorMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService{

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserMapper userMapper;
    
    @Override
    public UserRespWithDetails findById(Long id) {
        return userMapper.entityToRespComp(getById(id));
    }

    @Override
    public UserResp create(UserReq request) {
        return userMapper.entityToResp(userRepository.save(userMapper.reqToEntity(request)));
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(getById(id));

    }

    @Override
    public UserResp update(UserReqToUpdate request, Long id) {
        User user = getById(id);
        userMapper.updateEntityFromReq(request, user);
        return userMapper.entityToResp(userRepository.save(user));
    }
    
    private User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("user")));
    }

    @Override
    public UserRespWithLoansAndBooks findUserLoans(Long id) {
        return userMapper.entityToResBooks(getById(id));
    }

    @Override
    public UserRespWithReservationsAndBooks findUserReservations(Long id) {
        return userMapper.entityToResReservations(getById(id));

    }
}
