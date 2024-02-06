package com.tasks.springboottasksapp.controller;

import com.tasks.springboottasksapp.model.Task;
import com.tasks.springboottasksapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    public void addTask(){

    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        try {
            List<Task> taskList = new ArrayList<>();
            taskRepository.findAll().forEach(taskList::add);

            if (taskList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public void getTaskById(){

    }

    @PostMapping
    public void updateTaskStatus(){

    }

    @GetMapping
    public void getTaskByStatus(){

    }

    @DeleteMapping
    public void deleteAllTasks(){

    }

    @DeleteMapping
    public void deleteTaskById(){

    }
}
