package com.example.Portfolio_BE.dao.mock;

import com.example.Portfolio_BE.dao.ProjectRepository;
import com.example.Portfolio_BE.models.Project;
import lombok.NonNull;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("test")
public class MockProjectRepository implements ProjectRepository {
    private final List<Project> mockProjects = MockData.mockProjects;

    @Override
    @NonNull
    public <S extends Project> S save(@NonNull S entity) {
        mockProjects.add(entity);
        return entity;
    }

    @Override
    @NonNull
    @SuppressWarnings("unchecked")
    public <S extends Project> Iterable<S> saveAll(Iterable<S> entities) {
        entities.forEach(mockProjects::add);
        return (Iterable<S>) mockProjects;
    }

    @Override
    @NonNull
    public Optional<Project> findById(@NonNull Integer integer) {
        return mockProjects.stream().filter(x -> x.getId() == integer).findFirst();
    }

    @Override
    public boolean existsById(@NonNull Integer integer) {
        return findById(integer).isPresent();
    }

    @Override
    @NonNull
    public Iterable<Project> findAll() {
        return mockProjects;
    }

    @Override
    @NonNull
    public Iterable<Project> findAllById(Iterable<Integer> integers) {
        List<Project> result = new ArrayList<>();
        for (Integer integer : integers) {
            Optional<Project> project = findById(integer);
            project.ifPresent(result::add);
        }
        return result;
    }

    @Override
    public long count() {
        return mockProjects.size();
    }

    @Override
    public void deleteById(@NonNull Integer integer) {
        mockProjects.removeIf(x -> x.getId() == integer);
    }

    @Override
    public void delete(@NonNull Project entity) {
        mockProjects.remove(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        for (Integer integer : integers) {
            Optional<Project> project = findById(integer);
            project.ifPresent(mockProjects::remove);
        }
    }

    @Override
    public void deleteAll(Iterable<? extends Project> entities) {
        for (Project project : entities) {
            mockProjects.remove(project);
        }
    }

    @Override
    public void deleteAll() {
        mockProjects.clear();
    }

}
