package com.jeison.library.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BookResp {

    private Long id;
    private String title;
    private String author;
    private int publicationYear;
    private String genre;
    private String isbn;

}
