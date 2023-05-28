package com.project.loremaster.repositories;

import com.project.loremaster.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface QuizRepository extends JpaRepository<QuizEntity, Long> {

    @Query("select q from QuizEntity q where q.region = ?1 and q.quizId not in ?2 order by random() fetch first 1 rows only")
    Optional<QuizEntity> findQuestion(int regionId, Integer[] pastQuestionId);

    @Query("select q from QuizEntity q where q.quizId not in ?1 order by random() fetch first 1 rows only")
    Optional<QuizEntity> findQuestionAllRegions(Integer[] pastQuestionId);
}
