package edu.yothcon.external.gift;

import static org.assertj.core.api.Assertions.assertThat;

import edu.yothcon.external.gift.application.port.out.GiftResultResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GiftAcceptanceTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    @DisplayName("금액과 받는사람을 선택하 선물을 요청한다.")
    public void send() {
        //given
        String payload = "{\"number\":\"01091658447\", \"amount\": 10000}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(payload, headers);
        ResponseEntity<GiftResultResponse> response =
            template.postForEntity("/apis/v1/send", entity, GiftResultResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody().getId()).isNotEmpty();
        assertThat(response.getBody().getStatus()).isEqualTo("SUCCESS");
        assertThat(response.getBody().getAmount()).isEqualTo(10000);
    }


}
