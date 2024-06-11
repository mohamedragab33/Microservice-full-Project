package com.microServiceArch.order_service.enums;

import lombok.Getter;

@Getter
public enum ServicesUrl {
    INVENTORY_SERVICE("localhost:9092/api/inventory");

    private final String url;

    ServicesUrl(String url) {
        this.url = url;
    }

}
