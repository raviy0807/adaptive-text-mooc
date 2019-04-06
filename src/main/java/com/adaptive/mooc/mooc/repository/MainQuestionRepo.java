package com.adaptive.mooc.mooc.repository;

import com.adaptive.mooc.mooc.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainQuestionRepo extends JpaRepository<Problem, Integer> {

    List<Problem> findByLevelAndTopic(Integer level, Integer topic);

}
