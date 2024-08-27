package com.TalesBrayan.EcommerceLES.entities.enums;

public enum TipoAddress {
    ENTREGA(0),
    COBRANCA(1);

    private int code;

    TipoAddress(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TipoAddress valueOf(int code) {
        for(TipoAddress value : TipoAddress.values()) {
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Address code!");
    }
}
