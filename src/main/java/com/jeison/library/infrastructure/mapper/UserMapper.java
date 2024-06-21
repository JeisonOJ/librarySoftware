package com.jeison.library.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.jeison.library.api.dto.request.UserReq;
import com.jeison.library.api.dto.request.UserReqToUpdate;
import com.jeison.library.api.dto.response.UserResp;
import com.jeison.library.api.dto.response.UserRespWithDetails;
import com.jeison.library.domain.entities.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    // @Mappings({
    // @Mapping(source = "id", target = "id"),
    // @Mapping(source = "userName", target = "userName"),
    // @Mapping(source = "email", target = "email"),
    // @Mapping(source = "fullName", target = "fullName"),
    // @Mapping(source = "role", target = "role"),
    // })

    User reqToEntity(UserReq userReq);

    User reqToEntityToUpdate(UserReqToUpdate userReqToUpdate);

    UserResp EntityToResp(User user);

    UserRespWithDetails EntityToRespComp(User user);

}
