package com.grakovich.salesaccountingserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("product")
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @JsonProperty("client")
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;
    @JsonProperty("user")

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("price")
    private Double price;

    public Order(Product product, Client client, User user, Integer amount, Double price) {
        this.product = product;
        this.client = client;
        this.user = user;
        this.amount = amount;
        this.price = price;
    }
}
