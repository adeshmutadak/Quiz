package com.example.Quiz.controller;

import com.example.Quiz.model.Quiz;
import com.example.Quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/quiz")
public class QuizController {

      @Autowired
private QuizService quizService;


    @PostMapping("/")
  public String addQuiz(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }

    @GetMapping("/get/{quizId}/{userAns}")
    public String giveQuizz(@RequestParam int quizId,@RequestParam int userAns){
        String ans=quizService.checkAns(quizId,userAns);
        return ans;
    }

  @GetMapping("/getAll")
    public List<Quiz>getAllList(){
        return quizService.getAllList();
  }

  @GetMapping("/getResultById/{id}")
    public Optional<Quiz> getById(@PathVariable int id){
        return quizService.getById(id);
  }


  @GetMapping("/active")
    public List<Quiz> getActiveQuiz(@RequestParam("start")
                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                  LocalDateTime date){
        return quizService.getActiveQuiz(date);
  }
}
