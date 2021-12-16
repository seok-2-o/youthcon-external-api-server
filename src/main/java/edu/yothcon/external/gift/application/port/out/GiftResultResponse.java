package edu.yothcon.external.gift.application.port.out;

public final class GiftResultResponse {

    private final String id;
    private final Long amount;
    private final String status;

    public GiftResultResponse(String id, Long amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
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
