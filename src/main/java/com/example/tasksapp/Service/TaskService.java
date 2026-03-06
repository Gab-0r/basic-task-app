package com.example.tasksapp.Service;


import com.example.tasksapp.DTO.Project.ProjectSummary;
import com.example.tasksapp.DTO.Task.TaskRequest;
import com.example.tasksapp.DTO.Task.TaskSummary;
import com.example.tasksapp.Model.Project;
import com.example.tasksapp.Model.Task;
import com.example.tasksapp.Repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    private final ProjectService projectService;

    public List<TaskSummary> all(){
        return repository.findAll().stream()
                .map( task -> new TaskSummary(task, new ProjectSummary(task.getProject())))
                .collect(Collectors.toList());
    }

    public TaskSummary findById(Long id){
        return repository.findById(id)
                .map(task -> new TaskSummary(task, new ProjectSummary(task.getProject())))
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task update(Long id, Task task){
        return repository.findById(id).map(existing -> {
            existing.setProject(task.getProject());
            existing.setDescription(task.getDescription());
            existing.setPriority(task.getPriority());
            existing.setCompleted(task.getCompleted());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task save(TaskRequest taskRequest){
        Project project = projectService.findById(taskRequest.getProjectId());
        return repository.save(Task.from(taskRequest, project));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
