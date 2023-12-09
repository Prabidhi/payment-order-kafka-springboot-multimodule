package com.prabidhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@EnableConfigurationProperties
public class OrderserviceKafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderserviceKafkaProducerApplication.class, args);
    }

}
