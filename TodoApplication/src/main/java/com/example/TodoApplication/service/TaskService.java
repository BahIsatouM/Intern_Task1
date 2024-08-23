package com.example.TodoApplication.service;

import com.example.TodoApplication.model.Task;
import com.example.TodoApplication.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return  taskRepository.findAll();
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    public  void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public  void deleteAllTask(){
        taskRepository.deleteAll();
    }




}
