package com.prabidhi.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prabidhi.entity.Order;
import com.prabidhi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Value("${order.topic.name}")
    private String topicName;

    ObjectMapper objectMapper = new ObjectMapper();

    public Order saveOrder(Order order) throws JsonProcessingException {
        order.setStatus("CREATED");
        order = orderRepository.save(order);

        String oderStr = objectMapper.writeValueAsString(order);
        kafkaTemplate.send(topicName, oderStr);
        return order;
    }

    public List<Order> getOrders(){
        List<Order> orderList = orderRepository.findAll();
        return orderList;
    }


}
