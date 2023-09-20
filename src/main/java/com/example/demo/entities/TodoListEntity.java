package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tbl_todo_list")
@Getter
@Setter
public class TodoListEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "priority", columnDefinition = "INT DEFAULT 1")
    private Integer priority = 1;

    @Column(name = "is_completed", columnDefinition = "TINYINT DEFAULT 0")
    private boolean isCompleted = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

}
