package com.adaptive.mooc.mooc.repository;

import com.adaptive.mooc.mooc.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepo extends JpaRepository<Score, Integer> {

}
