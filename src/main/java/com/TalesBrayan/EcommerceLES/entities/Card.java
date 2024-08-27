package com.TalesBrayan.EcommerceLES.entities;

import com.TalesBrayan.EcommerceLES.entities.enums.TipoFlag;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_card")
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 13, max = 16 , message = "Card Number should be between 13 and 16 numbers")
    private String cardNumber;

    @NotNull
    private String cardNameImpress;


    @NotNull
    private Integer flag;

    @NotNull
    @Size(min = 3 , max = 4, message = "The security number should be between 3 and 4 numbers")
    private String cardSecurityCode;

    private boolean cardPreference;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    public Card (){}

    public Card(Long id, String cardNumber, String cardNameImpress, TipoFlag flag, String cardSecurityCode, boolean cardPreference, Client client) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardNameImpress = cardNameImpress;
        setFlag(flag);
        this.cardSecurityCode = cardSecurityCode;
        this.cardPreference = cardPreference;
        this.client = client;
    }

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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(TipoFlag flag) {
        if(flag != null)
            this.flag = flag.getCode();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return id.equals(card.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
