package com.TalesBrayan.EcommerceLES.entities.enums;

public enum TipoClientStatus {
    INATIVO(0),
    ATIVO(1);

    private int code;

    TipoClientStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TipoClientStatus valueOf(int code) {
        for(TipoClientStatus value : TipoClientStatus.values()) {
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid ClientStatus code!");
    }
}
