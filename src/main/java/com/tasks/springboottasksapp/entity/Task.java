package com.tasks.springboottasksapp.entity;

import lombok.Data;

@Data
public class Task {
    private int id;
    private String name;
    private String description;
    private String status;
    private String date;
}
