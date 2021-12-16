package edu.yothcon.external.gift.application.service;

import edu.yothcon.external.gift.application.port.in.SendGiftCommand;
import edu.yothcon.external.gift.application.port.out.GiftResultResponse;
import edu.yothcon.external.gift.compnent.SmsSender;
import java.text.MessageFormat;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class GiftService {

    private static final String MESSAGE = "{0} 에게 {1}원 배달의 민족 상품권 선물해주세요.";

    private final SmsSender sender;

    public GiftService(SmsSender sender) {
        this.sender = sender;
    }

    public GiftResultResponse send(SendGiftCommand command) {

        String msg = MessageFormat.format(MESSAGE, command.getNumber(), command.getAmount());
        if(sender.send(msg)) {
            return  GiftResultResponse.success(command.getAmount());
        }
        return GiftResultResponse.fail();
    }


}
