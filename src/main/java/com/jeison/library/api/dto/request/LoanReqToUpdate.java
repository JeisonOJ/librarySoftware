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
@Builder
@NoArgsConstructor
public class LoanReqToUpdate {

    @NotNull(message = "returnDate required")
    private LocalDateTime returnDate;
    @NotBlank(message = "status required")
    @Size(min = 4, max = 20, message = "status must between 4 and 20 characters")
    private String status;

}
