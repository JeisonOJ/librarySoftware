package com.jeison.library.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRespWithDetails {

    private Long id;
    private String title;
    private String author;
    private int publicationYear;
    private String genre;
    private String isbn;
    private List<LoanResp> loans;
    private List<ReservationResp> reservations;

}
