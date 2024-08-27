package com.TalesBrayan.EcommerceLES.entities;

import com.TalesBrayan.EcommerceLES.entities.enums.TipoClientStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.time.LocalDate;
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

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    //@NotNull
    private List<Phones> phone = new ArrayList<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    //@NotNull
    private List<Address> address = new ArrayList<>();

    private LocalDate dataCadastro;

    private TipoClientStatus status;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public Client(){}
    public Client(Long id, String name, String CPF, String email, String password, List<Phones> phone, List<Address> address ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = CPF;
        this.password = password;
        setPhone(phone);
        setAddress(address);
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

    public List<Phones> getPhone() {
        return phone;
    }

    public void setPhone(List<Phones> phone) {
        this.phone = phone;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public TipoClientStatus getStatus() {
        return status;
    }

    public void setStatus(TipoClientStatus status) {
        this.status = status;
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

    @PrePersist
    protected void onCreate() {
        this.dataCadastro = LocalDate.now();
        status = TipoClientStatus.ATIVO;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phones=" + (phone != null ? phone + " phones" : "No phones") +
                ", address=" + (address != null ? address + " address" : "No address") +
                ", dataCadastro=" + dataCadastro +
                ", orders=" + orders +
                '}';
    }



}