package com.jeison.library.infrastructure.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.jeison.library.api.dto.request.ReservationReq;
import com.jeison.library.api.dto.request.ReservationToUpdate;
import com.jeison.library.api.dto.response.ReservationResp;
import com.jeison.library.api.dto.response.ReservationRespWithBooks;
import com.jeison.library.api.dto.response.ReservationRespWithDetails;
import com.jeison.library.domain.entities.Reservation;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {

        Reservation reqToEntity(ReservationReq ReservationReq);

        void updateEntityFromReq(ReservationToUpdate request, @MappingTarget Reservation reservation);

        ReservationResp entityToResp(Reservation Reservation);

        ReservationRespWithDetails entityToRespComp(Reservation Reservation);
        ReservationRespWithBooks entityToRespBooks(Reservation Reservation);

        List<ReservationResp> entityToList(List<Reservation> loanList);

}
