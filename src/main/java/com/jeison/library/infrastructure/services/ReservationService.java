package com.jeison.library.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeison.library.api.dto.request.ReservationReq;
import com.jeison.library.api.dto.request.ReservationToUpdate;
import com.jeison.library.api.dto.response.ReservationRespWithDetails;
import com.jeison.library.domain.entities.Book;
import com.jeison.library.domain.entities.Reservation;
import com.jeison.library.domain.entities.User;
import com.jeison.library.domain.repositories.BookRepository;
import com.jeison.library.domain.repositories.ReservationRepository;
import com.jeison.library.domain.repositories.UserRepository;
import com.jeison.library.infrastructure.abstract_services.IReservationService;
import com.jeison.library.infrastructure.mapper.ReservationMapper;
import com.jeison.library.utils.exceptions.BadRequestException;
import com.jeison.library.utils.messages.ErrorMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    @Autowired
    private final ReservationRepository reservationRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final ReservationMapper reservationMapper;

    @Override
    public ReservationRespWithDetails findById(Long id) {
        return reservationMapper.entityToRespComp(getById(id));
    }

    @Override
    public ReservationRespWithDetails create(ReservationReq request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("user")));
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("book")));
        Reservation reservation = reservationMapper.reqToEntity(request);
        reservation.setBook(book);
        reservation.setUser(user);
        return reservationMapper.entityToRespComp(reservationRepository.save(reservation));

    }

    @Override
    public ReservationRespWithDetails update(ReservationToUpdate request, Long id) {
        Reservation reservation = getById(id);
        reservationMapper.updateEntityFromReq(request, reservation);
        return reservationMapper.entityToRespComp(reservationRepository.save(reservation));
    }

    @Override
    public void delete(Long id) {
        reservationRepository.delete(getById(id));

    }

    private Reservation getById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("reservation")));
    }
}
