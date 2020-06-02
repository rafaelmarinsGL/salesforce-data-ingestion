package com.gorillalogic.salesforce.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-dev.properties")
@ActiveProfiles("test")
public class IngestionControllerIntegrationTest {

    @Autowired
    IngestionController ingestionController;

    @Test
    public void testDataIngestion() {
        ingestionController.ingestData();
    }

}
