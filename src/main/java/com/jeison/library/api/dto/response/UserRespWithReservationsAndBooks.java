package com.jeison.library.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRespWithReservationsAndBooks {

    private Long id;
    private String userName;
    private String email;
    private String fullName;
    private String role;
    private List<ReservationRespWithBooks> reservations;

}
