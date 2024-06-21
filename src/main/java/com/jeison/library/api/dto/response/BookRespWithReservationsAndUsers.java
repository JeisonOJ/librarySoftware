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
public class BookRespWithReservationsAndUsers {

    private Long id;
    private String title;
    private String author;
    private int publicationYear;
    private String genre;
    private String isbn;
    private List<ReservationRespWithUsers> reservations;

}
