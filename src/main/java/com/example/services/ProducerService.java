package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.dto.ProductDTO;

import jakarta.annotation.PostConstruct;

@Component
public class ProducerService {

	@Autowired
    public final KafkaTemplate<String,Object> kafkaTemplate;

    @Value("${apache.kafka.topic.name}")
	private String apacheKafkaTopicName;
    
    public ProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Object message){
        this.kafkaTemplate.send(apacheKafkaTopicName, message);
        System.out.println("Message is sent to kafka : " + message);
    }

    @PostConstruct
    public void generateMessage() {
    	// String türünde göderilen mesaj test
    	/*
    	for (int i = 1; i <= 10; i++) {
			send("Message denemmmeeee  : "+i);
		}*/
    	
    	//Object türünde gönderilen mesaj test
//        public String title;
//        public String description;
//        public String color;
//        public int price;
//        public boolean isInStock;   	
    	ProductDTO productA = new ProductDTO("titleA","descriptionA","colorA",10,true);
    	send(productA);
    	System.out.println("Message is sent to kafka : " + productA);
    	ProductDTO productB = new ProductDTO("titleB","descriptionB","colorB",20,true);
    	send(productB);
    	System.out.println("Message is sent to kafka : " + productB);  	
    	ProductDTO productC = new ProductDTO("titleC","descriptionC","colorC",30,true);
    	send(productC);
    	System.out.println("Message is sent to kafka : " + productC);  	
    	ProductDTO productD = new ProductDTO("titleD","descriptionD","colorD",40,true);
    	send(productD);
    	System.out.println("Message is sent to kafka : " + productD);  	
    	ProductDTO productE = new ProductDTO("titleE","descriptionE","colorE",50,true);
    	send(productE);
    	System.out.println("Message is sent to kafka : " + productE);  	
    }
}
