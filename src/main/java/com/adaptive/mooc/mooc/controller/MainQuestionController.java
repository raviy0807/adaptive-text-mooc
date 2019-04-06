package com.adaptive.mooc.mooc.controller;

import com.adaptive.mooc.mooc.model.Problem;
import com.adaptive.mooc.mooc.service.MainQuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController(value = "/main")
public class MainQuestionController {

    @Autowired
    MainQuestionServices mainQuestionServices;

    @PostMapping("/getfirst")
    public List<Problem> getFirstQuestion(@RequestBody String payload){

        return mainQuestionServices.getFirstProblem(payload);

    }

    @PostMapping("/next")
    public List<Problem> getnextQuestion(@RequestBody String payload){

        return mainQuestionServices.getProblem(payload);

    }

}
