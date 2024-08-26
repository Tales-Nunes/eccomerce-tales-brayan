package com.TalesBrayan.EcommerceLES.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_phone")
public class Phones implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 15, message = "Phone number cannot exceed 15 characters")
    @NotNull
    private String phone;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;


    public Phones(){}

    public Phones(Long id, String phone, Client client) {
        this.id = id;
        this.phone = phone;
        this.client = client;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        if (!(o instanceof Phones phone)) return false;
        return id.equals(phone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Phones{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", clientId=" + (client != null ? client.getId() : null) +
                '}';
    }
}
