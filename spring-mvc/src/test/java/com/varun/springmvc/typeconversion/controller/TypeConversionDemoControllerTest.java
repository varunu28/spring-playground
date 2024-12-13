package com.varun.springmvc.typeconversion.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TypeConversionDemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHelloEndpoint() throws Exception {
        var nestedInput = """
            {
              "token": "token",
              "moreNestedInput": {
                "idOne": "id1",
                "idTwo": "id2",
                "idThree": "id3"
              }
            }
            """;

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/demo/hello")
                .param("nestedInput", nestedInput)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string("Hello World! tokenid1id2id3"));
    }

}