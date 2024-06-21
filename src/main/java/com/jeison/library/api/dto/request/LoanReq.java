package com.jeison.library.api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanReq {

    @NotNull(message = "returnDate required")
    private LocalDateTime returnDate;
    @NotBlank(message = "status required")
    @Size(min = 4, max = 20, message = "status must between 4 and 20 characters")
    private String status;
    @NotNull(message = "user id required")
    private Long userId;
    @NotNull(message = "book id required")
    private Long bookId;

}
