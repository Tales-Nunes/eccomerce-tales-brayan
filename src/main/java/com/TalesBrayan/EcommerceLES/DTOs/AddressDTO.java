package com.TalesBrayan.EcommerceLES.DTOs;

import com.TalesBrayan.EcommerceLES.entities.enums.TipoAddress;

public class AddressDTO {
    private String cep;
    private String address;
    private String number;
    private String complement;
    private Long cityId;
    private TipoAddress tipoAddress;
    private String addressNickname;


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public TipoAddress getTipoAddress() {
        return tipoAddress;
    }

    public void setTipoAddress(TipoAddress tipoAddress) {
        this.tipoAddress = tipoAddress;
    }

    public String getAddressNickname() {
        return addressNickname;
    }

    public void setAddressNickname(String addressNickname) {
        this.addressNickname = addressNickname;
    }
}
