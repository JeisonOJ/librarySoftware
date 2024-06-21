package com.jeison.library.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationRespWithDetails {

    private Long id;
    private LocalDateTime reservationDate;
    private String status;
    private UserResp user;
    private BookResp book;


}
