package edu.yothcon.external.gift.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

import edu.yothcon.external.gift.compnent.SmsSender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
class GiftServiceTest {

    @MockBean
    private SmsSender sender;

    @Mock
    private GiftService service;

    @Test
    public void send() {

        //given & when
        service.send();


        //then
        verify(sender).send(anyString(), anyString());
    }

}