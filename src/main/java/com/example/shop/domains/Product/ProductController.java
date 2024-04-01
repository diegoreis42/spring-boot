package com.example.shop.domains.Product;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductRepository repository;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody @Valid CreateProductDTO product) {

        return ResponseEntity.ok(repository.save(new Product(product)));
    }

    @PatchMapping("{id}")
    public ResponseEntity<Product> edit(@PathVariable("id") final UUID id, @RequestBody CreateProductDTO product) {
       Product product2 = new Product(product);
       product2.setId(id);
        return ResponseEntity.ok(repository.save(product2));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final UUID id) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getOne(@PathVariable("id") final UUID id) {
        return ResponseEntity.of(repository.findById(id));
    }
}
