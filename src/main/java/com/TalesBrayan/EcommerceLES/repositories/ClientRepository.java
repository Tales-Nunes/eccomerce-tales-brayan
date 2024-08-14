package com.TalesBrayan.EcommerceLES.repositories;

import com.TalesBrayan.EcommerceLES.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
