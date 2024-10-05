package com.example.Portfolio_BE.services;

import com.cloudinary.Cloudinary;
import com.example.Portfolio_BE.config.EnvironmentConfig;
import com.example.Portfolio_BE.dao.MediaRepository;
import com.example.Portfolio_BE.models.MediaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class MediaService {
    private final Cloudinary cloudinary;
    private final MediaRepository mediaRepo;

    @Autowired
    MediaService(MediaRepository mediaRepo, Cloudinary cloudinary) {
        this.mediaRepo = mediaRepo;
        this.cloudinary = cloudinary;
    }

    public Iterable<MediaData> getMediaByProject(int id) {
        return mediaRepo.getMediaByProjectId(id);
    }

    public boolean postMediaData(int id, MediaData mediaData, MultipartFile file) {
        try {
            mediaData.setProjectId(id);
            Map returnValues = cloudinary.uploader().upload(file, EnvironmentConfig.params);
            String dataUrl = returnValues.get("url").toString();
            if (dataUrl == null || dataUrl.isEmpty()) mediaData.setAddress("");
            mediaData.setAddress((String) returnValues.get("secure_url"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
        //mediaRepo.save(mediaData) != null;
    }

    public boolean updateMediaData(int id, MediaData mediaData) {
        mediaData.setProjectId(id);
        mediaRepo.delete(mediaData);
        mediaRepo.save(mediaData);
        return true;
    }

    public boolean deleteMedia(int id, int mediaId) {
        mediaRepo.deleteById(mediaId);
        return true;
    }
}
