package com.example.Portfolio_BE.controllers;

import com.example.Portfolio_BE.models.TechnologyStackItem;
import com.example.Portfolio_BE.services.TechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/portfolio/tech")
public class TechController {

    private final TechService techService;

    @Autowired
    public TechController(TechService techService) {
        this.techService = techService;
    }

    @PostMapping
    public ResponseEntity<String> postNewTechnology(@RequestBody TechnologyStackItem item) {
        techService.saveItem(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TechnologyStackItem>> getAllTechnologies() {
        List<TechnologyStackItem> result = techService.getAllTechs();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<String> updateTechnology(@RequestBody TechnologyStackItem item) {
        if (techService.updateItem(item))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



    @DeleteMapping
    public ResponseEntity<String> deleteTechnology(@RequestBody TechnologyStackItem item) {
        if (techService.deleteItem(item))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
