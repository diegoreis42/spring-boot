package com.example.shop.domains.Product;

import java.math.BigInteger;

public record CreateProductDTO(String name, BigInteger price, Integer stock) {
}
