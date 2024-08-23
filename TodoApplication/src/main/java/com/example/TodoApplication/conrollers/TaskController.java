package com.example.TodoApplication.conrollers;

import com.example.TodoApplication.model.Task;
import com.example.TodoApplication.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController{

    @Autowired
    private TaskService taskService;

    @GetMapping("/taks")
    public String getAllTasks(Model model){
        model.addAttribute("tasks", taskService.getAllTasks());
        return "task_list";
    }

    @GetMapping("/add-task")
    public String addTaskForm(Model model){
        model.addAttribute("task", new Task());
        return "add_task";
    }

    @PostMapping("/add-task")
    public String addTask(Task task){
        taskService.saveTask(task);
        return "redirect:/taks";
    }

    @GetMapping("/edit-task/{id}")
    public String editTaskForm(@PathVariable Long id, Model model){
        Task task = taskService.getTaskById(id);
        if (task != null){
            model.addAttribute("task", task);
            return "edit_task";
        } else {
            return "redirect:/taks";
        }
    }

    @PostMapping("/update-task/{id}")
    public String updateTask(@PathVariable Long id, Task task) {
        Task existingTask = taskService.getTaskById(id);
        if (existingTask != null) {
          //  existingTask.setTitle(task.getTitle());
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            taskService.updateTask(existingTask);
        }
        return "redirect:/taks";
    }
    @GetMapping("/delete-task/{id}")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/taks";
    }
    @GetMapping("/delete-all-tasks")
    public String deleteAllTasks(){
        taskService.deleteAllTask();
        return "redirect:/taks";
    }


}
