package com.TalesBrayan.EcommerceLES.repositories;

import com.TalesBrayan.EcommerceLES.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
