package com.boot.poc.productService.helper;

import com.boot.poc.productService.model.Product;
import com.boot.poc.productService.model.transferobject.ProductDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductHelper {

    public static List<ProductDTO> convertToProductDTO(List<Product> list){
        if(!list.isEmpty() && list != null) {
            return list.stream().map(product -> new ProductDTO(product.getId(), product.getProductName(),
                    product.getProductDesc(), product.getProductQty(), product.getPrice())).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
    public static ProductDTO convertToProductDTO(Product product){
        if(product != null) {
            return new ProductDTO(product.getId(), product.getProductName(),
                    product.getProductDesc(), product.getProductQty(), product.getPrice());
        }
        return new ProductDTO();
    }

    public static Product updateProduct(Long id, Product prd,Product prd1) {
        prd1.setProductName(prd.getProductName());
        prd1.setProductDesc(prd.getProductDesc());
        prd1.setProductQty(prd.getProductQty());
        prd1.setPrice(prd.getPrice());
        return prd1;
    }
}
