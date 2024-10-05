package com.example.Portfolio_BE.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "imagesrc")
    private String imageSrc;
    // Many-to-Many relationship between Project and TechnologyStackItem
    @ManyToMany
    @JoinTable(
            name = "project_technologystack",  // Join table name
            joinColumns = @JoinColumn(name = "projectid"),  // Foreign key for Project in the join table
            inverseJoinColumns = @JoinColumn(name = "technologyid")  // Foreign key for TechnologyStackItem
    )
    private List<TechnologyStackItem> technologyStack;
    @Column(name = "description")
    private String description;
    @Column(name = "giturl")
    private String gitUrl;
    @Column(name = "accessurl")
    private String accessUrl;


}
