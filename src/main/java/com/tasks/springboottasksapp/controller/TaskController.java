package com.tasks.springboottasksapp.controller;

import com.tasks.springboottasksapp.model.Task;
import com.tasks.springboottasksapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/addTask")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        Task taskObj = taskRepository.save(task);

        return new ResponseEntity<>(taskObj, HttpStatus.OK);
    }

    @GetMapping("/getAllTasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        try {
            List<Task> taskList = new ArrayList<>();
            taskRepository.findAll().forEach(taskList::add);

            if (taskList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(taskList, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getTaskById/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Optional<Task> taskData = taskRepository.findById(id);

        if (taskData.isPresent()){
            return new ResponseEntity<>(taskData.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateTaskStatus/{id}")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id, @RequestBody Task newTaskData){
        Optional<Task> oldTaskData = taskRepository.findById(id);

        if (oldTaskData.isPresent()){
            Task updatedTaskData = oldTaskData.get();
            updatedTaskData.setStatus(newTaskData.getStatus());

            Task taskObj = taskRepository.save(updatedTaskData);
            return new ResponseEntity<>(taskObj, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getTaskByStatus/{status}")
    public ResponseEntity<List<Task>> getTaskByStatus(@PathVariable String status){
        List<Task> taskByStatus = new ArrayList<>();
        taskRepository.findTaskByStatus(status).forEach(taskByStatus::add);

        if (taskByStatus.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(taskByStatus, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTaskById/{id}")
    public ResponseEntity<HttpStatus> deleteTaskById(@PathVariable Long id){
        taskRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllTasks")
    public ResponseEntity<HttpStatus> deleteAllTasks(){
        taskRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
