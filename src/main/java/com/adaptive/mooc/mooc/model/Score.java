package com.adaptive.mooc.mooc.model;

import javax.persistence.*;

@Entity
public class Score {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "user", nullable = false)
    String user_name;

    @Column(name = "score_1", nullable = true)
    int score_1;

    @Column(name = "score_2", nullable = true)
    int score_2;

    @Column(name = "score_3", nullable = true)
    int score_3;

    @Column(name = "score_4", nullable = true)
    int score_4;

    @Column(name = "score_5", nullable = true)
    int score_5;

    @Column(name = "idx", nullable = true)
    int index;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore_1() {
        return score_1;
    }

    public void setScore_1(int score_1) {
        this.score_1 = score_1;
    }

    public int getScore_2() {
        return score_2;
    }

    public void setScore_2(int score_2) {
        this.score_2 = score_2;
    }

    public int getScore_3() {
        return score_3;
    }

    public void setScore_3(int score_3) {
        this.score_3 = score_3;
    }

    public int getScore_4() {
        return score_4;
    }

    public void setScore_4(int score_4) {
        this.score_4 = score_4;
    }

    public int getScore_5() {
        return score_5;
    }

    public void setScore_5(int score_5) {
        this.score_5 = score_5;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Score(String user_name, int score_1, int score_2, int score_3, int score_4, int score_5, int index) {
        super();
        this.user_name = user_name;
        this.score_1 = score_1;
        this.score_2 = score_2;
        this.score_3 = score_3;
        this.score_4 = score_4;
        this.score_5 = score_5;
        this.index = index;
    }

    public Score() {
    }
}
