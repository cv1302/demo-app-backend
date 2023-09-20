package com.example.demo.repository;

import com.example.demo.entities.TodoListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TodoListRepository extends JpaRepository<TodoListEntity, Long> {

    /**
     * Get todo list by user name
     *
     * @param userName username
     * @return List of TodoListEntity
     */
    @Query("SELECT tl FROM TodoListEntity tl WHERE tl.userEntity.name = :userName")
    List<TodoListEntity> findByUser(@Param("userName") String userName);
}
