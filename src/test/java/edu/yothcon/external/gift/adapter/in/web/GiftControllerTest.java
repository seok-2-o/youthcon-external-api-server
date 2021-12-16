package edu.yothcon.external.gift.adapter.in.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class GiftControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void send() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/apis/v1/send")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"number\":\"01091658447\", \"amount\": 10000}"))
        .andExpect(status().isCreated());

    }

}
