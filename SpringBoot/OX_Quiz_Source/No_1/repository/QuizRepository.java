package com.my.QuizApplication.repository;

import com.my.QuizApplication.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long>{

    @Query(value = "SELECT * FROM quiz_list ORDER BY content ASC", nativeQuery = true)
    List<Quiz> findAllByContentAsc();

    @Query(value = "SELECT * FROM quiz_list ORDER BY content DESC", nativeQuery = true)
    List<Quiz> findAllByContentDesc();

    @Query(value = "SELECT * FROM quiz_list ORDER BY name ASC", nativeQuery = true)
    List<Quiz> findAllByNameAsc();

    @Query(value = "SELECT * FROM quiz_list ORDER BY name DESC", nativeQuery = true)
    List<Quiz> findAllByNameDesc();

    @Query(value = "SELECT * FROM quiz_list ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Quiz randomQuiz();
}
