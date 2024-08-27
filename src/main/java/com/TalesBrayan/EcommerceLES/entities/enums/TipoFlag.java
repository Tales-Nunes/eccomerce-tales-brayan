package com.TalesBrayan.EcommerceLES.entities.enums;

public enum TipoFlag {
    VISA(0),
    MASTERCARD(1),
    ELO(2),
    DISCOVER(3),
    AMERICAN_EXPRESS(4),
    HIPERCARD(5),
    AMEX(6);

    private int code;

    TipoFlag(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TipoFlag valueOf(int code) {
        for(TipoFlag value : TipoFlag.values()) {
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Flag code!");
    }

}
