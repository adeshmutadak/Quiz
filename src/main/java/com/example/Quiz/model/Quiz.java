package com.example.Quiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer quizId;
    private String question;
    private List<String> options;
    private int rightAns;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;




//    public int getRightAns() {
//        return rightAns;
//    }
//
//    public void setRightAns(int rightAns) {
//        this.rightAns = rightAns;
//    }
}
