package com.jeison.library.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRespWithDetails {

    private Long id;
    private String userName;
    private String email;
    private String fullName;
    private String role;
    private List<LoanResp> loans;
    private List<ReservationResp> reservations;

}
