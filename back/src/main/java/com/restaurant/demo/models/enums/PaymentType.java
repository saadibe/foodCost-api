package com.restaurant.demo.models.enums;

public enum PaymentType {
    CB("CB"), CHQ("CHQ"), ESP("ESP");

    private String type;

    private PaymentType(String type){
        this.type = type;
    }
}
