package com.adaptive.mooc.mooc.service;

import com.adaptive.mooc.mooc.model.Question;
import com.adaptive.mooc.mooc.repository.PreliminaryQuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreliminaryQuestionServices {

    @Autowired
    PreliminaryQuestionRepo preliminaryQuestionRepo;

    public Question evaluate(Question que) {

        int id = que.getId();
        String user_sol = que.getSol();

        Question q = (Question) preliminaryQuestionRepo.findById(id).get();
        if (!user_sol.equals(q.getSol())){
            return preliminaryQuestionRepo.findById(id-1).get();
        }

            return preliminaryQuestionRepo.findById(id+1).get();


    }


    public Question getQuestion(int rating) {

        return preliminaryQuestionRepo.findById(rating).get();

    }

    public void addQues(Question question) {

        preliminaryQuestionRepo.save(question);
    }
}
