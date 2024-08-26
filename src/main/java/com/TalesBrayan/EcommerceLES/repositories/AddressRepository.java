package com.TalesBrayan.EcommerceLES.repositories;

import com.TalesBrayan.EcommerceLES.entities.Address;
import com.TalesBrayan.EcommerceLES.entities.Phones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
