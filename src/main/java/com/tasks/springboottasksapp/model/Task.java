package com.tasks.springboottasksapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Tasks")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String status;
    private String date;
}
