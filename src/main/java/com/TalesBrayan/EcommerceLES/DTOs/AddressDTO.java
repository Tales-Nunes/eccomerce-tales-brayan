package com.TalesBrayan.EcommerceLES.DTOs;

public class AddressDTO {
    private String cep;
    private String address;
    private String number;
    private String complement;
    private Long cityId;

    public AddressDTO(){}
    public AddressDTO(String cep, String address, String number, String complement, Long cityId) {
        this.cep = cep;
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.cityId = cityId;
    }

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
}
