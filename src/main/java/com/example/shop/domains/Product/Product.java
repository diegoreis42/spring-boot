package com.example.shop.domains.Product;

import java.math.BigInteger;

import com.example.shop.shared.schemas.GenericSchema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product extends GenericSchema {

    @Column
    private String name;

    @Column
    private BigInteger price;

    @Column
    private Integer stock;

    public Product(CreateProductDTO product) {
        this.name = product.name();
        this.price = product.price();
        this.stock = product.stock();
    }
}
