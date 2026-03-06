package com.example.tasksapp.Controller;

import com.example.tasksapp.DTO.Project.ProjectRequest;
import com.example.tasksapp.Model.Project;
import com.example.tasksapp.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService service;

    @GetMapping("")
    public List<Project> all(){
        return service.all();
    }

    @GetMapping("/{id}")
    public Project one(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Project save(@RequestBody ProjectRequest projectRequest){
        return service.save(projectRequest);
    }

    @PatchMapping("/{id}")
    public Project update(@PathVariable Long id, @RequestBody Project project){
        return service.update(id, project);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }

}
