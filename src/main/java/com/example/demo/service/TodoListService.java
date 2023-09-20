package com.example.demo.service;

import com.example.demo.entities.TodoListEntity;

import java.util.List;

public interface TodoListService {

    /**
     * Get all todo list
     *
     * @return List of TodoListEntity
     */
    List<TodoListEntity> getAllTodoList();

    /**
     * Get todo list by id
     *
     * @param id todo list id
     * @return TodoListEntity
     */
    TodoListEntity getTodoListById(Long id);

    /**
     * Create new todo list
     *
     * @param todoList TodoListEntity
     * @return TodoListEntity
     */
    TodoListEntity createTodoList(TodoListEntity todoList);

    /**
     * Update todo list
     *
     * @param id       todo list id
     * @param todoList TodoListEntity
     * @return TodoListEntity
     */
    TodoListEntity updateTodoList(Long id, TodoListEntity todoList);

    /**
     * Delete todo list by id
     *
     * @param id todo list id
     */
    void deleteTodoList(Long id);

    /**
     * Find all todo list by user name
     *
     * @param userName username
     * @return TodoListEntity
     */
    List<TodoListEntity> findTodoListByUser(String userName);
}
