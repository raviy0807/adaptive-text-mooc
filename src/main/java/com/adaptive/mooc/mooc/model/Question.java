package com.adaptive.mooc.mooc.model;


import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;

    @Column(name = "question")
    private String question;

    @Column(name = "opt1")
    private String opt1;

    @Column(name = "opt2")
    private String opt2;

    @Column(name = "opt3")
    private String opt3;

    @Column(name = "sol")
    private String sol;

    public Question(String question, String opt1, String opt2, String opt3, String sol) {
        super();
        this.question = question;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.sol = sol;

    }
    public Question(){

    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getSol() {
        return sol;
    }

    public void setSol(String sol) {
        this.sol = sol;
    }






}
