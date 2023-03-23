package com.example.autoservice.model;

enum OrderStatus {
    ACCEPTED("accepted"),
    IN_PROGRESS("in progress"),
    COMPLETED("completed successfully"),
    NOT_COMPLETED("not completed successfully"),
    PAID("paid");
    private String value;

    OrderStatus(String value) {
        this.value = value;
    }
}
