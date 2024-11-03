package com.boot.poc.productService.model.transferobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String productName;
    private String productDesc;
    private int productQty;
    private int price;
}
