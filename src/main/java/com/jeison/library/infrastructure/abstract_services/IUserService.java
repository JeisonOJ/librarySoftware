package com.jeison.library.infrastructure.abstract_services;

import com.jeison.library.api.dto.request.UserReq;
import com.jeison.library.api.dto.request.UserReqToUpdate;
import com.jeison.library.api.dto.response.UserResp;
import com.jeison.library.api.dto.response.UserRespWithDetails;

public interface IUserService extends CrudService<UserReq,UserReqToUpdate,UserResp,UserRespWithDetails,Long>{

}
