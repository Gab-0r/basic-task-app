package com.example.tasksapp.Controller;

import com.example.tasksapp.DTO.Task.TaskRequest;
import com.example.tasksapp.DTO.Task.TaskSummary;
import com.example.tasksapp.Model.Task;
import com.example.tasksapp.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping("")
    public List<TaskSummary> all(){
        return service.all();
    }

    @GetMapping("/{id}")
    public TaskSummary one(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Task save(@RequestBody TaskRequest taskRequest){
        return service.save(taskRequest);
    }

    @PatchMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task){
        return service.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }


}
