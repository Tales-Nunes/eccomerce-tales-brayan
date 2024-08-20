package com.TalesBrayan.EcommerceLES.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;


    @CPF(message = "Invalid CPF")
    @NotNull(message = "CPF is required")
    @Column(name = "CPF", unique = true)
    private String cpf;

    @NotNull
    @Email(message = "Email should be valid")
    private String email;

    @NotNull
    @Size(min = 6, max = 100, message = "Password should be between 6 and 100 characters")
    private String password;

    @Size(max = 15, message = "Phone number cannot exceed 15 characters")
    @NotNull
    private String phone;

    @Size(min = 8, max = 8, message = "CEP code cannot exceed 10 characters")
    @NotNull
    private String cep;

    @Size(max = 255, message = "Address cannot exceed 255 characters")
    @NotNull
    private String address;

    @NotNull
    private String number;

    @Size(max = 255, message = "Complement cannot exceed 255 characters")
    @NotNull
    private String complement;

    @Size(max = 100, message = "City cannot exceed 100 characters")
    @NotNull
    private String city;

    @Size(max = 2, message = "State should have 2 characters")
    @NotNull
    private String state;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public Client(){}
    public Client(Long id, String name, String CPF, String email, String password, String phone, String CEP, String address, String number, String complement, String city, String state ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = CPF;
        this.password = password;
        this.phone = phone;
        this.cep = CEP;
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String CPF) {
        this.cpf = CPF.replaceAll("\\D", "");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String CEP) {
        this.cep = CEP;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /*private LocalDate dataCadastro;

    @PrePersist
    protected void onCreate() {
        this.dataCadastro = LocalDate.now();
    }
    */
}