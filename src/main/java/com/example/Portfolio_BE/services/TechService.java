package com.example.Portfolio_BE.services;

import com.example.Portfolio_BE.dao.TechRepository;
import com.example.Portfolio_BE.models.TechnologyStackItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechService {
    private final TechRepository techRepository;

    @Autowired
    public TechService(TechRepository techRepository) {
        this.techRepository = techRepository;
    }

    public void saveItem(TechnologyStackItem item) {
        techRepository.save(item);
    }

    public List<TechnologyStackItem> getAllTechs() {
        return (List<TechnologyStackItem>) techRepository.findAll();
    }

    public boolean deleteItem(TechnologyStackItem item) {
        techRepository.delete(item);
        return !techRepository.existsById(item.getId());
    }

    public void deleteById(int id) {
        techRepository.deleteById(id);
    }

    public boolean updateItem(TechnologyStackItem item) {
        if (techRepository.existsById(item.getId())) {
            techRepository.save(item);
            return true;
        }
        return false;
    }
}
