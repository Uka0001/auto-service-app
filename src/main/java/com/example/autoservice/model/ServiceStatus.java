package com.example.autoservice.model;

enum ServiceStatus {
    PAID("paid"),
    NOT_PAID("not paid");

    private String value;

    ServiceStatus(String value) {
        this.value = value;
    }
}
