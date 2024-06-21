package com.jeison.library.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeison.library.domain.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

    public List<Book> findByTitleContainingAndAuthorContainingAndGenreContaining(String title,String author, String genre);

}
