package com.example.Portfolio_BE.controllers;

import com.example.Portfolio_BE.models.MediaData;
import com.example.Portfolio_BE.services.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio/projects/media/{id}")
public class ProjectMediaController {
    private final MediaService mediaService;

    @Autowired
    ProjectMediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping
    public ResponseEntity<List<MediaData>> getMediaData(@PathVariable("id") int id) {
        List<MediaData> mediaData = (List<MediaData>) mediaService.getMediaByProject(id);
        if (mediaData == null || mediaData.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(mediaData, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> postMediaData(@PathVariable("id") int id, @RequestParam(value = "image") MultipartFile file, @RequestBody MediaData mediaData) {
        if (mediaService.postMediaData(id, mediaData, file)) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PatchMapping
    public ResponseEntity<String> patchMediaData(@PathVariable("id") int id, @RequestBody MediaData mediaData) {
        if (mediaService.updateMediaData(id, mediaData)) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteMediaData(@PathVariable("id") int id, @RequestBody int mediaId) {
        if (mediaService.deleteMedia(id, mediaId)) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
