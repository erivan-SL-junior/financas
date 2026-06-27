package com.financas.demo.occurrence.repository;

import com.financas.demo.occurrence.entity.OccurrenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccurrenceRepository extends JpaRepository<OccurrenceEntity, Long> {
}
