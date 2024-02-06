package com.tasks.springboottasksapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="Tasks")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Task {
    private Long id;
    private String name;
    private String description;
    private String status;
    private String date;
}
