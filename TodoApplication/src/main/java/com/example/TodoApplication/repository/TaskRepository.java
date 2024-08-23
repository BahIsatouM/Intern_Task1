package com.example.TodoApplication.repository;


import com.example.TodoApplication.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
