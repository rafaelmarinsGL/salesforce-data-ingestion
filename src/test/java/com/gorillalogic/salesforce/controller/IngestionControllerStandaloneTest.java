package com.gorillalogic.salesforce.controller;

import com.gorillalogic.salesforce.service.IngestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(IngestionController.class)
public class IngestionControllerStandaloneTest {

    @MockBean
    IngestionService ingestionService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCreateReadDelete() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/salesforce/ingest-data"))
                .andExpect(status().isOk());
    }

}
