package com.gorillalogic.salesforce.controller;

import com.gorillalogic.salesforce.service.IngestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/salesforce")
public class IngestionController {

    private IngestionService ingestionService;

    public IngestionController(IngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    @GetMapping("/ingest-data")
    public void ingestData() {
        ingestionService.ingestData();
    }
}
