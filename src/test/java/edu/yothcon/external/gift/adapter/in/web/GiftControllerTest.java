package edu.yothcon.external.gift.adapter.in.web;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import edu.yothcon.external.gift.application.port.out.GiftResultResponse;
import edu.yothcon.external.gift.application.service.GiftService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class GiftControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GiftService service;

    @Test
    public void send() throws Exception {
        BDDMockito.given(service.send(any())).willReturn(GiftResultResponse.success(10000L));
        mvc.perform(MockMvcRequestBuilders.post("/apis/v1/send")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"number\":\"01091658447\", \"amount\": 10000}"))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("status").value("SUCCESS"))
        .andExpect(jsonPath("amount").value(10000));

    }

}
