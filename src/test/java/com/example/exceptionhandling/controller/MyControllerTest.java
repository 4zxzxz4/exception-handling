package com.example.exceptionhandling.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureWebMvc
public class MyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void handlePerControllerException() throws Exception {
        mockMvc
            .perform(get("/hello"))
            .andDo(print())
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("reason").value("THERE_IS_NOT_MATCHED_API_VERSION"));
    }

    @Test
    public void handleAllControllerException() throws Exception {
        mockMvc
                .perform(post("/helloAll").content(""))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("reason").value("PARAMETER_NAME_IS_NOT_FOUNDED"));
    }
}