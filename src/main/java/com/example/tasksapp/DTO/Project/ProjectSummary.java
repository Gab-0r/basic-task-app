package com.example.tasksapp.DTO.Project;

import com.example.tasksapp.Model.Project;

public class ProjectSummary {

    private Long id;
    private String name;

    public ProjectSummary(Project project){
        this.setId(project.getId());
        this.setName(project.getName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
