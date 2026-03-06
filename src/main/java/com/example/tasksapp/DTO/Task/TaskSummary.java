package com.example.tasksapp.DTO.Task;

import com.example.tasksapp.DTO.Project.ProjectSummary;
import com.example.tasksapp.Model.Task;

public class TaskSummary {

    private Long id;
    private ProjectSummary project;
    private String title;
    private String priority;
    private Boolean completed;

    public TaskSummary(Task task, ProjectSummary projectSummary){
        this.setId(task.getId());
        this.setProject(projectSummary);
        this.setTitle(task.getTitle());
        this.setPriority(task.getPriority());
        this.setCompleted(task.getCompleted());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectSummary getProject() {
        return project;
    }

    public void setProject(ProjectSummary project) {
        this.project = project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

}
