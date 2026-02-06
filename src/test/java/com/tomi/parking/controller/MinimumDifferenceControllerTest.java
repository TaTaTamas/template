package com.tomi.parking.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MinimumDifferenceControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void minimumDifferenceCalculationIsRightWithSorting() throws Exception {
        mockMvc.perform(post("/minimumdifference")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[30,20,10,15,5]"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    public void minimumDifferenceCalculationIsRight() throws Exception {
        mockMvc.perform(get("/minimumdifference?numbers=30,20,10,15,5"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }
}