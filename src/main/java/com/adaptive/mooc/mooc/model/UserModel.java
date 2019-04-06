package com.adaptive.mooc.mooc.model;

import javax.persistence.*;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "user_name")
    String name;

    @Column(name = "user_score")
    int score;

    public UserModel(String name, int score) {
        super();
        this.name = name;
        this.score = score;
    }

    public UserModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
