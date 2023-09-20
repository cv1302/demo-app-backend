package com.example.demo.service;

import com.example.demo.entities.TodoListEntity;
import com.example.demo.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListServiceImpl implements TodoListService {

    private final TodoListRepository todoListRepository;

    @Autowired
    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public List<TodoListEntity> getAllTodoList() {
        return todoListRepository.findAll();
    }

    @Override
    public TodoListEntity getTodoListById(Long id) {
        return todoListRepository.findById(id).orElse(null);
    }

    @Override
    public TodoListEntity createTodoList(TodoListEntity todoList) {
        return todoListRepository.save(todoList);
    }

    @Override
    public TodoListEntity updateTodoList(Long id, TodoListEntity updatedTodoList) {
        TodoListEntity existingTodoList = getTodoListById(id);
        if (existingTodoList != null) {
            existingTodoList.setTitle(updatedTodoList.getTitle());
            existingTodoList.setDescription(updatedTodoList.getDescription());
            existingTodoList.setDueDate(updatedTodoList.getDueDate());
            existingTodoList.setPriority(updatedTodoList.getPriority());
            existingTodoList.setCompleted(updatedTodoList.isCompleted());
            return todoListRepository.save(existingTodoList);
        }
        return null;
    }

    @Override
    public void deleteTodoList(Long id) {
        todoListRepository.deleteById(id);
    }

    @Override
    public List<TodoListEntity> findTodoListByUser(String userName) {
        return todoListRepository.findByUser(userName);
    }

}