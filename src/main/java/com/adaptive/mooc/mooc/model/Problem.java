package com.adaptive.mooc.mooc.model;

import javax.persistence.*;

@Entity
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int topic;

    private int level;

    private String description;

    private String option1;

    private String option2;

    private String option3;

    private String solution;

    public Problem(int topic, int level, String description, String option1, String option2, String option3, String solution) {
        super();
        this.topic = topic;
        this.level = level;
        this.description = description;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.solution = solution;
    }

    public Problem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopic() {
        return topic;
    }

    public void setTopic(int topic) {
        this.topic = topic;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
