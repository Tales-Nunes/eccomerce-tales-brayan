package com.TalesBrayan.EcommerceLES.repositories;

import com.TalesBrayan.EcommerceLES.entities.Client;
import com.TalesBrayan.EcommerceLES.entities.Phones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhonesRepository extends JpaRepository<Phones, Long> {
}
