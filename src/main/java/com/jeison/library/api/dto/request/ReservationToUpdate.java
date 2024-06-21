package com.jeison.library.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationToUpdate {

    @NotBlank(message = "status required")
    @Size(min = 4, max = 20, message = "status must between 4 and 20 characters")
    private String status;
}
