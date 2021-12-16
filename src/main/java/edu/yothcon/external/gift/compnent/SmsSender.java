package edu.yothcon.external.gift.compnent;

import com.google.inject.internal.util.Maps;
import java.util.HashMap;
import java.util.Map;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import net.nurigo.java_sdk.api.Message;

@Component
public class SmsSender {

    @Value("${cool-sms.api.key}")
    private String key;
    @Value("${cool-sms.api.secret}")
    private String secret;
    @Value("${cool-sms.api.sender}")
    private String sender;


    public boolean send(String message) {
        return send("01091658447", message);
    }

    public boolean send(String phone, String message) {
        Message m = new Message(key, secret);
        Map<String, String> params = Map.of(
            "to", phone,
            "from", sender,
            "type", "SMS",
            "text", message
        );
        System.out.println(params);
        try {
            m.send(new HashMap<>(params));
            return true;
        } catch (CoolsmsException e) {
            return false;
        }
    }




}
