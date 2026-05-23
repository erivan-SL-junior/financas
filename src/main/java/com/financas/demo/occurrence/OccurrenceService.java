package com.financas.demo.occurrence;

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
