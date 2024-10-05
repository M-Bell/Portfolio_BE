package com.example.Portfolio_BE.dao;

import com.example.Portfolio_BE.models.MediaData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends CrudRepository<MediaData, Integer> {
    @Query("SELECT MD FROM MediaData AS MD WHERE MD.projectId=?1")
    Iterable<MediaData> getMediaByProjectId(int projectID);
}
