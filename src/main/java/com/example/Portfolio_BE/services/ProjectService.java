package com.example.Portfolio_BE.services;

import com.example.Portfolio_BE.dao.ProjectRepository;
import com.example.Portfolio_BE.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjects() {
        return (List<Project>) projectRepository.findAll();

    }

    public boolean addProject(Project project) {
        return projectRepository.save(project) != null;
    }

    public Project getProjectById(String id) {
        return projectRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    public boolean patchProject(String id, Project project) {
        return projectRepository.save(project) != null;
    }

    public boolean deleteProject(String id) {
        projectRepository.deleteById(Integer.valueOf(id));
        return getProjectById(id) == null;
    }
}
