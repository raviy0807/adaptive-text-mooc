package com.adaptive.mooc.mooc.controller;


import com.adaptive.mooc.mooc.model.Question;
import com.adaptive.mooc.mooc.service.PreliminaryQuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PreliminaryQuestionController {

    @Autowired
    PreliminaryQuestionServices preliminaryQuestionServices;
    @PostMapping("/enroll")
    public Question enrollQuestion(@RequestBody Question question){

        return preliminaryQuestionServices.evaluate(question);
    }

    @GetMapping("/getques/{rating}")
    public Question getQuestion(@PathVariable int rating){

        return preliminaryQuestionServices.getQuestion(rating);

    }

    @PostMapping("/addQue")
    public void Addques(@RequestBody Question question){

        preliminaryQuestionServices.addQues(question);
    }


}
