package com.TalesBrayan.EcommerceLES.entities.enums;

public enum TipoOrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    TipoOrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TipoOrderStatus valueOf(int code) {
        for(TipoOrderStatus value : TipoOrderStatus.values()) {
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code!");
    }
}
