package com.sda.traiangradinaru.webshop.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "order_product")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "status")
    private OrderStatus status;
    @Column(name = "creation_date")
    private Timestamp creationDate;
    @OneToOne
    @JoinColumn(name = "customer_id") //doar in aceasta tabela utilizam prefixul customer_id!!!
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "bill_Id")
    private Bill bill;
    @ManyToMany
    @JoinTable(name = "order_products",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    private List<Product> products;

    public Order(OrderStatus status, Timestamp creationDate, Customer customer, Bill bill) {
        this.status = status;
        this.creationDate = creationDate;
        this.customer = customer;
        this.bill = bill;
    }



    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", creationDate=" + creationDate +
                ", customer=" + customer +
                ", bill=" + bill +
                '}';
    }
}
