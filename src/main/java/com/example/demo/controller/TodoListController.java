package com.example.demo.controller;

import com.example.demo.entities.TodoListEntity;
import com.example.demo.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo-list")
public class TodoListController {

    private final TodoListService todoListService;

    @Autowired
    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    /**
     * Get all data todo_list API
     *
     * @return TodoListEntity
     */
    @GetMapping
    public ResponseEntity<List<TodoListEntity>> getAllTodoLists() {
        List<TodoListEntity> todoLists = todoListService.getAllTodoList();
        return new ResponseEntity<>(todoLists, HttpStatus.OK);
    }

    /**
     * Get todo list by id API
     *
     * @param id id of todo list
     * @return TodoListEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity<TodoListEntity> getTodoListById(@PathVariable Long id) {
        TodoListEntity todoList = todoListService.getTodoListById(id);
        if (todoList != null) {
            return new ResponseEntity<>(todoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Create new todo list API
     *
     * @param todoList TodoListEntity
     * @return TodoListEntity
     */
    @PostMapping
    public ResponseEntity<TodoListEntity> createTodoList(@RequestBody TodoListEntity todoList) {
        TodoListEntity createdTodoList = todoListService.createTodoList(todoList);
        return new ResponseEntity<>(createdTodoList, HttpStatus.CREATED);
    }

    /**
     * Update data of todo list
     *
     * @param id             id of todo_list
     * @param todoListEntity TodoListEntity
     * @return TodoListEntity
     */
    @PutMapping("/{id}")
    public ResponseEntity<TodoListEntity> updateTodoList(@PathVariable Long id, @RequestBody TodoListEntity todoListEntity) {
        TodoListEntity todoList = todoListService.updateTodoList(id, todoListEntity);
        if (todoList != null) {
            return new ResponseEntity<>(todoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete dodo list by Id
     *
     * @param id id of todo list
     * @return void
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoList(@PathVariable Long id) {
        todoListService.deleteTodoList(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Find all todo list by user name
     *
     * @param userName username
     * @return list of todo_list
     */
    @GetMapping("/find-by-user")
    public ResponseEntity<List<TodoListEntity>> findTodoListByUser(@RequestParam String userName) {
        List<TodoListEntity> todoLists = todoListService.findTodoListByUser(userName);
        return new ResponseEntity<>(todoLists, HttpStatus.OK);
    }
}