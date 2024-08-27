package com.TalesBrayan.EcommerceLES.DTOs;

import com.TalesBrayan.EcommerceLES.entities.Client;
import com.TalesBrayan.EcommerceLES.entities.enums.TipoFlag;

public class CardDTO {
    private Long id;
    private String cardNumber;
    private String cardNameImpress;
    private TipoFlag flag;
    private String cardSecurityCode;
    private boolean cardPreference;

    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNameImpress() {
        return cardNameImpress;
    }

    public void setCardNameImpress(String cardNameImpress) {
        this.cardNameImpress = cardNameImpress;
    }

    public TipoFlag getFlag() {
        return flag;
    }

    public void setFlag(TipoFlag flag) {
        this.flag = flag;
    }

    public String getCardSecurityCode() {
        return cardSecurityCode;
    }

    public void setCardSecurityCode(String cardSecurityCode) {
        this.cardSecurityCode = cardSecurityCode;
    }

    public boolean isCardPreference() {
        return cardPreference;
    }

    public void setCardPreference(boolean cardPreference) {
        this.cardPreference = cardPreference;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
