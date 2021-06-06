package com.sda.traiangradinaru.webshop.repository;

import com.sda.traiangradinaru.webshop.model.Account;
import com.sda.traiangradinaru.webshop.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
