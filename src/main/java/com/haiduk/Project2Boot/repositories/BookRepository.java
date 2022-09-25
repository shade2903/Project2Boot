package com.haiduk.Project2Boot.repositories;


import com.haiduk.Project2Boot.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByOrderByYear();
    List<Book> findByTitleStartingWith(String title);

}
