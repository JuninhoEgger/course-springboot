package com.educandoweb.workshop.repositories;

import com.educandoweb.workshop.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
