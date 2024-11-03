package com.boot.poc.productService.service;

import com.boot.poc.productService.model.Product;
import com.boot.poc.productService.model.transferobject.ProductDTO;

import java.util.List;


public interface ProductService {

    public List<ProductDTO> getAllProducts();

    public ProductDTO getProductById(Long id);

    public ProductDTO createProduct(Product product);

    public ProductDTO updateProduct(Long id, Product product);

    public void deleteProduct(Long id);
}
