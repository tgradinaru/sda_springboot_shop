package com.sda.traiangradinaru.webshop.service;

import com.sda.traiangradinaru.webshop.model.*;
import com.sda.traiangradinaru.webshop.repository.BillRepository;
import com.sda.traiangradinaru.webshop.repository.CustomerRepository;
import com.sda.traiangradinaru.webshop.repository.OrderRepository;
import com.sda.traiangradinaru.webshop.repository.ProductRepository;
import com.sda.traiangradinaru.webshop.service.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final BillRepository billRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, BillRepository billRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.billRepository = billRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public void save(OrderDTO orderDTO) {
        Optional<Customer> customer = customerRepository.findById(orderDTO.getCustomerId());
        if (customer.isPresent()) {
            List<Product> products = new ArrayList<>();
            for (Long productId : orderDTO.getProductIds()) {
                Optional<Product> product = productRepository.findById(productId);
                if (product.isPresent()) {
                    products.add(product.get());
                } else {
                    throw new IllegalArgumentException("No product was found in DB for Id: " + productId);
                }
            }
            save(customer.get(), products);
        } else {
            throw new IllegalArgumentException("No customer was found in DB for Id: " + orderDTO.getCustomerId());
        }
    }

    public void save(Customer customer, List<Product> products) {
        Bill bill = new Bill();
        bill.setIssueDate(Timestamp.from(Instant.now()));
        //bill.setDueDate(Timestamp.from(Instant.now().plus(7, ChronoUnit.DAYS)));
        bill.setDueDate(Timestamp.from(Instant.now().plus(Duration.ofDays(7)))); //the same

        bill.setCurrency(products.get(0).getCurrency());
        double total = 0.0;
        for (Product product : products) {
            total = total + product.getPrice();
        }
        bill.setAmount(total);
        billRepository.save(bill);


        Order order = new Order();
        order.setProducts(products);
        order.setStatus(OrderStatus.NEW);
        order.setCreationDate(Timestamp.from(Instant.now()));
        order.setCustomer(customer);
        order.setBill(bill);

        orderRepository.save(order);
    }


    public void updateStatus(Long orderId, OrderStatus status) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            order.get().setStatus(status);
            orderRepository.save(order.get());
        } else{
            throw new IllegalArgumentException("Order not found");
        }
    }
}
