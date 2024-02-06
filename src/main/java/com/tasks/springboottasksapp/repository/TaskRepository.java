package com.tasks.springboottasksapp.repository;

import com.tasks.springboottasksapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    //Query Methods
    //Retrieve a list of tasks by their status
    List<Task> findTaskByStatus(String status);
}
