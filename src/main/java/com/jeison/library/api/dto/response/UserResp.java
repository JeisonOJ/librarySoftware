package com.jeison.library.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResp {

    private Long id;
    private String userName;
    private String email;
    private String fullName;
    private String role;
}
