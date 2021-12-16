package edu.yothcon.external.gift.application.port.out;

import java.util.UUID;

public final class GiftResultResponse {

    private final String id;
    private final Long amount;
    private final String status;

    public GiftResultResponse(String id, Long amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public static GiftResultResponse success(Long amount) {
        return new GiftResultResponse(UUID.randomUUID().toString(), amount, "SUCCESS");
    }

    public static GiftResultResponse fail() {
        return new GiftResultResponse(UUID.randomUUID().toString(), 0L, "FAIL");
    }

    public String getId() {
        return id;
    }

    public Long getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}
