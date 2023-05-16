package com.example.Quiz.repo;

import com.example.Quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IRepo extends CrudRepository<Quiz, Integer> {

@Query(value = "SELECT * FROM quiz WHERE start_date_time <=:localDateEndTime AND end_date_time >=:localDateEndTime", nativeQuery = true)
    List<Quiz> findByStarterDateBetweenStartDateTimeAndEndDateTime( LocalDateTime localDateEndTime);
}
