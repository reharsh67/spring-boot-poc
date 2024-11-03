package com.boot.poc.productService.service.impl;

import com.boot.poc.productService.helper.ProductHelper;
import com.boot.poc.productService.model.Product;
import com.boot.poc.productService.model.transferobject.ProductDTO;
import com.boot.poc.productService.repository.ProductRepository;
import com.boot.poc.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductDTO> getAllProducts() {
        return ProductHelper.convertToProductDTO(productRepository.findAll());
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return ProductHelper.convertToProductDTO(productRepository.findById(id).orElseThrow());
    }
    @Override
    public ProductDTO createProduct(Product product) {
        return ProductHelper.convertToProductDTO(productRepository.save(product));
    }

    @Override
    public  ProductDTO updateProduct(Long id, Product prd) {
        Product prd1 = productRepository.findById(id).orElseThrow();
        return ProductHelper.convertToProductDTO(productRepository.save(ProductHelper.updateProduct(id,prd,prd1)));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
