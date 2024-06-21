package com.jeison.library.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.jeison.library.api.dto.request.ReservationReq;
import com.jeison.library.api.dto.request.ReservationToUpdate;
import com.jeison.library.api.dto.response.ReservationResp;
import com.jeison.library.api.dto.response.ReservationRespWithDetails;
import com.jeison.library.domain.entities.Reservation;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {

    Reservation reqToEntity(ReservationReq ReservationReq);

    Reservation reqToEntityToUpdate(ReservationToUpdate ReservationReqToUpdate);

    @Mappings({
            @Mapping(source = "reservationDate", target = "reservationDate", dateFormat = "yyyy-MM-dd HH-mm-ss")
    })
    ReservationResp EntityToResp(Reservation Reservation);

    @Mappings({
            @Mapping(source = "reservationDate", target = "reservationDate", dateFormat = "yyyy-MM-dd HH-mm-ss")
    })
    ReservationRespWithDetails EntityToRespComp(Reservation Reservation);

}
