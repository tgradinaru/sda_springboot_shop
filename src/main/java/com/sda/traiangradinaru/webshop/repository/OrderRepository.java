package com.sda.traiangradinaru.webshop.repository;

import com.sda.traiangradinaru.webshop.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
