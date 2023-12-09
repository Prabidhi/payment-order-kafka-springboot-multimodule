package com.prabidhi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prabidhi.entity.Order;
import com.prabidhi.entity.User;
import com.prabidhi.repository.OrderRepository;
import com.prabidhi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderNotificationListener {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;



    @KafkaListener(
            topics = "order-topic",
            groupId = "my-Payment-Group"
    )
    public void processOrder(String orderString) throws JsonProcessingException {
        log.info("Received message {} ", orderString);
        Order order = objectMapper.readValue(orderString, Order.class);
        User user = userRepository.findById(order.getUserId()).get();

        if(user.getBalance()<order.getOrderAmount()){
            order.setStatus("SUCCESS");
            user.setBalance(user.getBalance()-order.getOrderAmount());
            userRepository.save(user);
        }
        orderRepository.save(order);



    }
}
