package com.boot.poc.orderService.model.transferobject;

import com.boot.poc.orderService.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private List<OrderItem> orderItems;
    private Long userId;
    private Double totalAmount;
}
