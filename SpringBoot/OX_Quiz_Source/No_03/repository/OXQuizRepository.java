package com.example.oxquizproject.repository;

import com.example.oxquizproject.dto.QuizDTO;
import com.example.oxquizproject.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OXQuizRepository extends JpaRepository<Quiz,Long> {
    @Query(value = "SELECT * FROM quiz ORDER BY id", nativeQuery = true)
    List<Quiz> searchAll();

    @Query(value = "SELECT * FROM quiz ORDER BY RAND() LIMIT 1", nativeQuery = true)
    List<Quiz> randQuiz();
}
