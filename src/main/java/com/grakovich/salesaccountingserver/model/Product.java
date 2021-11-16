package com.grakovich.salesaccountingserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("unit_cost")
    private Double unitCost;
    @JsonProperty("model")
    private String model;

    @JsonProperty("productType")
    @ManyToOne(fetch = FetchType.EAGER)
    private ProductType productType;

    public Product(Integer amount, Double unitCost, String model, ProductType productType) {
        this.amount = amount;
        this.unitCost = unitCost;
        this.model = model;
        this.productType = productType;
    }
}