package com.example.tasksapp.Service;


import com.example.tasksapp.DTO.Project.ProjectRequest;
import com.example.tasksapp.Model.Project;
import com.example.tasksapp.Repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository repository;

    public List<Project> all(){
        return repository.findAll();
    }

    public Project findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public Project save(ProjectRequest projectRequest){
        return repository.save(Project.from(projectRequest));
    }

    public Project update(Long id, Project project){
        return repository.findById(id).map(existing -> {
            existing.setName(project.getName());
            existing.setDescription(project.getDescription());
            existing.setStartDate(project.getStartDate());
            existing.setEndDate(project.getEndDate());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
