package com.boot.poc.productService.repository;

import com.boot.poc.productService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
