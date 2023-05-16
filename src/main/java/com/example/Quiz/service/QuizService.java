package com.example.Quiz.service;

import com.example.Quiz.model.Quiz;
import com.example.Quiz.repo.IRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private IRepo iRepo;


    public String addQuiz(Quiz quiz) {
        iRepo.save(quiz);
        return "Added Succesfully";
    }


    public String checkAns(int quizId, int userAns) {
        Quiz quiz = iRepo.findById(quizId).get();
        if (quiz.getRightAns() == userAns) {
            return "Hurray Right Answer...";
        }
        return "Sorry Wrong Answer";
    }


    public List<Quiz> getAllList() {
        return (List<Quiz>) iRepo.findAll();
    }

    public Optional<Quiz> getById(int id) {
        return iRepo.findById(id);
    }

    public List<Quiz> getActiveQuiz( LocalDateTime localDateEndTime) {
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        LocalDateTime startDateTime = quiz.getStartDateTime();
//        LocalDateTime endDateTime = quiz.getEndDateTime();
//
//        if (currentDateTime.isBefore(startDateTime)) {
//            // Quiz start time is in the future
//            return "Quiz start time should be in the future.";
//        } else if (currentDateTime.isAfter(endDateTime)) {
//            // Quiz end time is in the past
//            return "Quiz end time should be in the future.";
//        } else {
//            // Create the quiz

            return iRepo.findByStarterDateBetweenStartDateTimeAndEndDateTime( localDateEndTime);



    }
}
