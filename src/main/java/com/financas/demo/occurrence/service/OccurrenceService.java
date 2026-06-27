package com.financas.demo.occurrence.service;

import com.financas.demo.occurrence.entity.OccurrenceEntity;
import com.financas.demo.occurrence.repository.OccurrenceRepository;
import org.springframework.stereotype.Service;

@Service
public class OccurrenceService {
    OccurrenceRepository occurrenceRepository;

    public OccurrenceService(OccurrenceRepository occurrenceRepository) {
        this.occurrenceRepository = occurrenceRepository;
    }

    public void save(OccurrenceEntity occurrenceEntity) {
        occurrenceRepository.save(occurrenceEntity);
    }
}
