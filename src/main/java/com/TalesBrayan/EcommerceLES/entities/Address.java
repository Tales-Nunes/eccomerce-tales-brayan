package com.TalesBrayan.EcommerceLES.entities;

import com.TalesBrayan.EcommerceLES.entities.enums.TipoAddress;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 8, max = 8, message = "CEP code cannot exceed 10 characters")
    //@NotNull
    private String cep;

    @Size(max = 255, message = "Address cannot exceed 255 characters")
    @NotNull
    private String address;

    @NotNull
    private String number;

    @Size(max = 255, message = "Complement cannot exceed 255 characters")
    @NotNull
    private String complement;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    @NotNull
    private Integer tipoAddress;


    @Size(max = 255, message = "Address Nickname cannot exceed 255 characters")
    private String addressNickname;

    public Address() {}

    public Address(Long id, String cep, String address, String number, String complement, City city, Client client, TipoAddress tipoAddress, String addressNickname) {
        this.id = id;
        this.cep = cep;
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.client = client;
        this.addressNickname = addressNickname;
        setTipoAddress(tipoAddress);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TipoAddress getTipoAddress() {
        return TipoAddress.valueOf(tipoAddress);
    }

    public void setTipoAddress(TipoAddress tipoAddress) {
        if(tipoAddress != null)
            this.tipoAddress = tipoAddress.getCode();
    }

    public String getAddressNickname(String addressNickname) {
        return this.addressNickname;
    }

    public void setAddressNickname(String addressNickname) {
        this.addressNickname = addressNickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address adress)) return false;
        return id.equals(adress.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                ", complement='" + complement + '\'' +
                ", city='" + city + '\'' +
                ", clientId=" + (client != null ? client.getId() : null) +
                ", addressNickname=" + addressNickname + '\'' +
                '}';
    }
}
