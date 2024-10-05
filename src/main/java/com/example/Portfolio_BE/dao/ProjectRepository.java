package com.example.Portfolio_BE.dao;

import com.example.Portfolio_BE.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {
    
}
