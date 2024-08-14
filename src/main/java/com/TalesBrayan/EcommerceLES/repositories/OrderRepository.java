package com.TalesBrayan.EcommerceLES.repositories;

import com.TalesBrayan.EcommerceLES.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
