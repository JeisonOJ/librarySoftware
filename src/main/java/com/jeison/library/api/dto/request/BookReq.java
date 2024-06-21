package com.jeison.library.api.dto.request;

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
public class BookReq {

    @NotBlank(message = "title required")
    @Size(min = 4, max = 100, message = "title must between 4 and 100 characters")
    private String title;
    @NotBlank(message = "author required")
    @Size(min = 4, max = 100, message = "author must between 4 and 100 characters")
    private String author;
    @NotNull(message = "publicationYear required")
    private int publicationYear;
    @NotBlank(message = "genre required")
    @Size(min = 4, max = 50, message = "genre must between 4 and 50 characters")
    private String genre;
    @NotBlank(message = "isbn required")
    @Size(min = 4, max = 20, message = "isbn must between 4 and 20 characters")
    private String isbn;

}
