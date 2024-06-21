package com.jeison.library.infrastructure.abstract_services;

import com.jeison.library.api.dto.request.ReservationReq;
import com.jeison.library.api.dto.request.ReservationToUpdate;
import com.jeison.library.api.dto.response.ReservationRespWithDetails;

public interface IReservationService extends
        CrudService<ReservationReq, ReservationToUpdate, ReservationRespWithDetails, ReservationRespWithDetails, Long> {

}
