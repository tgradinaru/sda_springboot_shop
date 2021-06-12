package com.sda.traiangradinaru.webshop.repository;

import com.sda.traiangradinaru.webshop.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
