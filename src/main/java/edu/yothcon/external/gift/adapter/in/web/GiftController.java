package edu.yothcon.external.gift.adapter.in.web;

import edu.yothcon.external.gift.application.port.out.GiftResultResponse;
import edu.yothcon.external.gift.application.port.in.SendGiftCommand;
import edu.yothcon.external.gift.application.service.GiftService;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GiftController {

    private final GiftService giftService;

    public GiftController(GiftService giftService) {
        this.giftService = giftService;
    }

    @PostMapping("/apis/v1/send")
    public ResponseEntity<GiftResultResponse> send(@RequestBody SendGiftCommand command) {
        return ResponseEntity.created(URI.create("/"))
            .body(giftService.send(command));
    }

}
