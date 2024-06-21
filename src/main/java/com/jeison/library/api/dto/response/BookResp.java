package com.jeison.library.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResp {

    private Long id;
    private String title;
    private String author;
    private int publicationYear;
    private String genre;
    private String isbn;

}
