package com.adaptive.mooc.mooc.repository;

import com.adaptive.mooc.mooc.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreliminaryQuestionRepo extends JpaRepository<Question, Integer> {
}
