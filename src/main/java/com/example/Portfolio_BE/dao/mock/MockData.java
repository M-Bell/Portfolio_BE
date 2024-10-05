package com.example.Portfolio_BE.dao.mock;

import com.example.Portfolio_BE.models.MediaData;
import com.example.Portfolio_BE.models.MediaType;
import com.example.Portfolio_BE.models.Project;
import com.example.Portfolio_BE.models.TechnologyStackItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockData {
    public static List<Project> mockProjects = new ArrayList<>();

    // Initialize the mockProjects list
    static {
        // Creating mock projects with the updated technology stack items
        mockProjects.add(new Project(0, "Portfolio Website", "assets/images/portfolio.png",
                new ArrayList<>(Arrays.asList(
                        new TechnologyStackItem(0, "Angular"),
                        new TechnologyStackItem(1, "TypeScript"),
                        new TechnologyStackItem(2, "Java"),
                        new TechnologyStackItem(3, "Spring Boot"),
                        new TechnologyStackItem(4, "CSS"),
                        new TechnologyStackItem(5, "HTML")
                )),
                "A personal portfolio website to showcase my projects, skills, and experience. The website is built using Angular framework for the frontend and Java/Spring Boot backend API integration. It features a responsive design, dynamic project data, and smooth navigation.",
                "https://github.com/M-Bell/Portfolio_FE", "http://localhost:4200/"));

        mockProjects.add(new Project(1, "E-Commerce Storefront", null,
                new ArrayList<>(Arrays.asList(
                        new TechnologyStackItem(6, "React"),
                        new TechnologyStackItem(7, "Node.js"),
                        new TechnologyStackItem(8, "Express"),
                        new TechnologyStackItem(9, "MongoDB")
                )),
                "A full-stack e-commerce platform with a shopping cart, product search, and secure checkout features.", null, null));

        mockProjects.add(new Project(2, "Real-Time Chat Application", null,
                new ArrayList<>(Arrays.asList(
                        new TechnologyStackItem(0, "Angular"),
                        new TechnologyStackItem(10, "Firebase"),
                        new TechnologyStackItem(11, "RxJS"),
                        new TechnologyStackItem(12, "SCSS")
                )),
                "A real-time messaging application using Firebase for authentication and real-time database.", null, null));

        mockProjects.add(new Project(3, "Task Management App", null,
                new ArrayList<>(Arrays.asList(
                        new TechnologyStackItem(13, "Vue.js"),
                        new TechnologyStackItem(14, "JavaScript"),
                        new TechnologyStackItem(15, "Bootstrap"),
                        new TechnologyStackItem(10, "Firebase")
                )),
                "A task management tool that allows users to organize tasks, set deadlines, and collaborate with teams.", null, null));

        mockProjects.add(new Project(4, "Weather Dashboard", null,
                new ArrayList<>(Arrays.asList(
                        new TechnologyStackItem(6, "React"),
                        new TechnologyStackItem(16, "OpenWeather API"),
                        new TechnologyStackItem(14, "JavaScript"),
                        new TechnologyStackItem(4, "CSS")
                )),
                "A dashboard that fetches real-time weather data from the OpenWeather API, showing forecasts and current conditions for selected cities.", null, null));

        mockProjects.add(new Project(5, "Blog Platform", null,
                new ArrayList<>(Arrays.asList(
                        new TechnologyStackItem(17, "Next.js"),
                        new TechnologyStackItem(18, "GraphQL"),
                        new TechnologyStackItem(19, "Tailwind CSS")
                )),
                "A modern blog platform that supports markdown content creation and dynamic routing using Next.js and GraphQL.", null, null));

        mockProjects.add(new Project(6, "Fitness Tracker", null,
                new ArrayList<>(Arrays.asList(
                        new TechnologyStackItem(20, "React Native"),
                        new TechnologyStackItem(21, "Redux"),
                        new TechnologyStackItem(7, "Node.js"),
                        new TechnologyStackItem(9, "MongoDB")
                )),
                "A mobile application that tracks users’ fitness activities and provides personalized workout recommendations.", null, null));
    }

    public static List<MediaData> mediaData = new ArrayList<>();

    // Initialize the mediaData list
    static {
        mediaData.add(new MediaData(0, 0, MediaType.IMG, "assets/images/image.png", "Tree", "Just a random tree"));
        mediaData.add(new MediaData(1, 0, MediaType.IMG, "assets/images/portfolio.png", "Portfolio main page", null));
    }
}
