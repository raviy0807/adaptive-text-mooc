package com.adaptive.mooc.mooc.repository;

import com.adaptive.mooc.mooc.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepo extends JpaRepository<UserModel, Integer> {
    UserModel findByName(String name);
}
