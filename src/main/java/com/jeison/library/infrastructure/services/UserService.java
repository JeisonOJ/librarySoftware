package com.jeison.library.infrastructure.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeison.library.api.dto.request.UserReq;
import com.jeison.library.api.dto.request.UserReqToUpdate;
import com.jeison.library.api.dto.response.UserRespWithDetails;
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
        return userMapper.EntityToRespComp(getById(id));
    }

    @Override
    public UserRespWithDetails create(UserReq request) {
        return userMapper.EntityToRespComp(userRepository.save(userMapper.reqToEntity(request)));
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(getById(id));

    }

    private User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("user")));
    }

    @Override
    public UserRespWithDetails update(UserReqToUpdate request, Long id) {
        User user = getById(id);
        User userToUpdate = userMapper.reqToEntityToUpdate(request);
        userToUpdate.setId(id);
        userToUpdate.setRole(user.getRole());
        return userMapper.EntityToRespComp(userRepository.save(userToUpdate));
    }

}
