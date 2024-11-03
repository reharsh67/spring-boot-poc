package com.boot.poc.orderService.service;

import com.boot.poc.orderService.model.Order;
import com.boot.poc.orderService.model.transferobject.OrderDTO;

import java.util.List;
import java.util.Optional;


public interface OrderService {

    public Order createOrder(OrderDTO order);

    public Optional<Order> getOrderById(Long id);

    public List<Order> getOrdersByUserId(Long  id);

    public List<Order> getAllOrders();

    public void deleteOrder(Long id);
}
