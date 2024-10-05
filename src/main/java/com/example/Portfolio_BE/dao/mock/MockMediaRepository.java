package com.example.Portfolio_BE.dao.mock;

import com.example.Portfolio_BE.dao.MediaRepository;
import com.example.Portfolio_BE.models.MediaData;
import lombok.NonNull;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("test")
public class MockMediaRepository implements MediaRepository {
    private final List<MediaData> mockMedia = MockData.mediaData;

    @Override
    @NonNull
    public <S extends MediaData> S save(@NonNull S entity) {
        mockMedia.add(entity);
        return entity;
    }

    @Override
    @NonNull
    @SuppressWarnings("unchecked")
    public <S extends MediaData> Iterable<S> saveAll(@NonNull Iterable<S> entities) {
        entities.forEach(mockMedia::add);
        return (Iterable<S>) mockMedia;
    }

    @Override
    @NonNull
    public Optional<MediaData> findById(@NonNull Integer integer) {
        return mockMedia.stream().filter(x -> x.getId() == integer).findFirst();
    }

    @Override
    public boolean existsById(@NonNull Integer integer) {
        return findById(integer).isPresent();
    }

    @Override
    @NonNull
    public Iterable<MediaData> findAll() {
        return mockMedia;
    }

    @Override
    @NonNull
    public Iterable<MediaData> findAllById(@NonNull Iterable<Integer> integers) {
        List<MediaData> result = new ArrayList<>();
        for (Integer integer : integers) {
            Optional<MediaData> project = findById(integer);
            project.ifPresent(result::add);
        }
        return result;
    }

    @Override
    public long count() {
        return mockMedia.size();
    }

    @Override
    public void deleteById(@NonNull Integer integer) {
        mockMedia.removeIf(x -> x.getId() == integer);
    }

    @Override
    public void delete(@NonNull MediaData entity) {
        mockMedia.remove(entity);
    }

    @Override
    public void deleteAllById(@NonNull Iterable<? extends Integer> integers) {
        for (Integer integer : integers) {
            Optional<MediaData> project = findById(integer);
            project.ifPresent(mockMedia::remove);
        }
    }

    @Override
    public void deleteAll(@NonNull Iterable<? extends MediaData> entities) {
        for (MediaData mediaData : entities) {
            mockMedia.remove(mediaData);
        }
    }

    @Override
    public void deleteAll() {
        mockMedia.clear();
    }

    @Override
    public Iterable<MediaData> getMediaByProjectId(int projectID) {
        return mockMedia.stream().filter(x -> x.getProjectId() == projectID).toList();
    }
}
