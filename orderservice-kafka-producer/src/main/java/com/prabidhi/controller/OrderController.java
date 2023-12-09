package com.prabidhi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prabidhi.entity.Order;
import com.prabidhi.service.OrderService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;



    @GetMapping("/all")
    public List<Order> getOrder(){
        return orderService.getOrders();
    }

    @PostMapping("/create")
    public Order saveOrder(@RequestBody Order order) throws JsonProcessingException {
        return orderService.saveOrder(order);

    }
}
