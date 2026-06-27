package com.financas.demo.occurrence.controller;

import com.financas.demo.occurrence.entity.OccurrenceEntity;
import com.financas.demo.occurrence.service.OccurrenceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("occurrence")
public class OccurrenceController {
    private final OccurrenceService occurrenceService;

    public OccurrenceController(OccurrenceService occurrenceService) {
        this.occurrenceService = occurrenceService;
    }
}
