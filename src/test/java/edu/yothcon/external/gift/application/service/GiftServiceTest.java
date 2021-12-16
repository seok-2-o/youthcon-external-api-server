package edu.yothcon.external.gift.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import edu.yothcon.external.gift.application.port.in.SendGiftCommand;
import edu.yothcon.external.gift.application.port.out.GiftResultResponse;
import edu.yothcon.external.gift.compnent.SmsSender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
class GiftServiceTest {

    @Mock
    private SmsSender sender;

    @InjectMocks
    private GiftService service;

    @Test
    public void send() {
        //given
        SendGiftCommand command = Mockito.mock(SendGiftCommand.class);
        given(command.getNumber()).willReturn("01012345678");
        given(command.getAmount()).willReturn(10000L);
        given(sender.send(anyString())).willReturn(true);

        // when
        GiftResultResponse response = service.send(command);

        //then
        assertThat(response.getStatus()).isEqualTo("SUCCESS");
    }

    @Test
    public void send_fail() {
        //given
        SendGiftCommand command = Mockito.mock(SendGiftCommand.class);
        given(command.getNumber()).willReturn("01012345678");
        given(command.getAmount()).willReturn(10000L);
        given(sender.send(anyString())).willReturn(false);

        // when
        GiftResultResponse response = service.send(command);

        //then
        assertThat(response.getStatus()).isEqualTo("FAIL");
    }

}