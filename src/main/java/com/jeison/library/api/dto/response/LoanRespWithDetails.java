package com.jeison.library.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRespWithDetails {

    private Long id;
    private LocalDateTime loanDate;
    private LocalDateTime returnDate;
    private String status;
    private UserResp user;
    private BookResp book;

}
