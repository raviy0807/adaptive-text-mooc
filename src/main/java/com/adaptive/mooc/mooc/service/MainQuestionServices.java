package com.adaptive.mooc.mooc.service;

import com.adaptive.mooc.mooc.model.Problem;
import com.adaptive.mooc.mooc.model.Score;
import com.adaptive.mooc.mooc.model.UserModel;
import com.adaptive.mooc.mooc.repository.MainQuestionRepo;
import com.adaptive.mooc.mooc.repository.ModelRepo;
import com.adaptive.mooc.mooc.repository.ScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MainQuestionServices {

    @Autowired
    ModelRepo modelRepo;

    @Autowired
    MainQuestionRepo mainQuestionRepo;

    @Autowired
    ScoreRepo scoreRepo;

    public List<Problem> getFirstProblem(String params) {



        String[] val = parseParam(params);
        String user_name = val[0];

        int[] user_answer = {
                Integer.parseInt(val[1]),
                Integer.parseInt(val[2]),
                Integer.parseInt(val[3]),
                Integer.parseInt(val[4])
        };

        int score = heuristic(user_answer);
        UserModel um = new UserModel(user_name, score);
        modelRepo.save(um);
        List<Problem> p = new ArrayList<>();
        mainQuestionRepo.findByLevelAndTopic(score,1).forEach(prob->p.add((Problem) prob));
        Score sc = new Score(user_name, 0, 0, 0, 0, 0, -4);
        scoreRepo.save(sc);
        return p;
    }

    public List<Problem> getProblem(String params) {
        String[] val = parseParam(params);
        String name = val[0];
        int score = getLatestScore(Integer.parseInt(val[1]));
        int topic = Integer.parseInt(val[2]);
        List<Problem> p = new ArrayList<>();
        UserModel um = modelRepo.findByName(name);
        int s = um.getScore();
        if (score==0){
            if(s>1){
                //Update Heuristic Function
                um.setScore(s-1);
            }
            mainQuestionRepo.findByLevelAndTopic(s, topic+1).forEach(prob->p.add((Problem) prob));
        }

        else{
            if(s < 5){
                um.setScore(s+1);
            }

            if (topic<5){
                topic = topic + 1;
            }
            else return null;
            modelRepo.save(um);
            mainQuestionRepo.findByLevelAndTopic(um.getScore(), topic).forEach(prob->p.add((Problem) prob));
        }
        return p;
    }

    private String[] parseParam(String params){
        String s = params.substring(params.indexOf('[')+1, params.lastIndexOf(']'));

        String[] val = s.split(",");

        return val;

    }

    private int getLatestScore(int params) {
        int i = params;
        Score ss = scoreRepo.findById(7).get();
        int idx = ss.getIndex();
        int flag = 0;

        if (idx == -4){
            ss.setScore_1(i);
        }

        else if(idx == -3){

            ss.setScore_2(i);
        }

        else if(idx == -2){

            ss.setScore_3(i);
        }

        else if(idx == -1){

            ss.setScore_4(i);
        }

        else if(idx == 0){

            ss.setScore_5(i);
        }

        else if(idx == 1){

            ss.setScore_1(i);
        }

        else if(idx == 2){

            ss.setScore_2(i);
        }

        else if(idx == 3){

            ss.setScore_3(i);
        }

        else if(idx == 4){

            ss.setScore_4(i);
        }
        else if(idx == 5){

            ss.setScore_5(i);
            flag = 1;
        }

        if (flag == 0){
            ss.setIndex(idx+1);
        }
        else{
            ss.setIndex(1);
        }

        int s1 = ss.getScore_1();
        int s2 = ss.getScore_2();
        int s3 = ss.getScore_3();
        int s4 = ss.getScore_4();
        int s5 = ss.getScore_5();

        int [] all_score = {s1, s2, s3, s4, s5};
        int finalScore=0;
        int newIdx = ss.getIndex();
        if (newIdx<0){
             finalScore = mostFrequent(all_score, all_score.length+(newIdx-1));
        }else{
             finalScore = mostFrequent(all_score, all_score.length);
        }

        scoreRepo.save(ss);

        return finalScore;

    }

    /**
     *  to be filled according to the algorithm
     * @param user_answer: which has sequential right or wrong entry
     *                      format eg: [0,1,0,1]
     * @return
     */
    public int heuristic(int[] user_answer){

        // write your code here **
        int user_model =1;
        if (user_answer[1]==1){
            if (user_answer[2]==1){
                //Increment based on the Confidence Index
                user_model = user_answer[0] + 1;
            }
            else {
                user_model = user_answer[0];
            }
        }
        else {
            if (user_answer[2]==1){
                //Decrement based on the Confidence Index
                if(user_answer[3]>10){
                    user_model = 1;
                }
                else {
                    user_model = user_answer[0] -1;
                }


            }
            else {
                //Lack of Confidence
                // Start with Basic level
                user_model = 1;
            }

        }
        return user_model;
    }

    static int mostFrequent(int arr[], int n)
    {

        // Insert all elements in hash
        Map<Integer, Integer> hp =
                new HashMap<Integer, Integer>();

        for(int i = 0; i < n; i++)
        {
            int key = arr[i];
            if(hp.containsKey(key))
            {
                int freq = hp.get(key);
                freq++;
                hp.put(key, freq);
            }
            else
            {
                hp.put(key, 1);
            }
        }

        // find max frequency.
        int max_count = 0, res = -1;

        for(Map.Entry<Integer, Integer> val : hp.entrySet())
        {
            if (max_count < val.getValue())
            {
                res = val.getKey();
                max_count = val.getValue();
            }
        }

        return res;
    }
}
