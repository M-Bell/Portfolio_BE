package com.example.Portfolio_BE.dao;

import com.example.Portfolio_BE.models.TechnologyStackItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechRepository extends CrudRepository<TechnologyStackItem, Integer> {
}
