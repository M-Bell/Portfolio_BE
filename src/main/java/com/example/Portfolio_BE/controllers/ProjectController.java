package com.example.Portfolio_BE.controllers;

import com.example.Portfolio_BE.models.Project;
import com.example.Portfolio_BE.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio/projects")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        List<Project> projects = projectService.getProjects();
        if (projects.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        if (projectService.addProject(project)) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable String id) {
        Project project = projectService.getProjectById(id);
        if (project == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable String id, @RequestBody Project project) {
        if (projectService.patchProject(id, project)) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable String id) {
        if (projectService.deleteProject(id)) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
