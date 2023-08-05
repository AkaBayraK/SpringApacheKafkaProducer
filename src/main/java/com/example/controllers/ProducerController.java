package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ProductDTO;
import com.example.services.ProducerService;

@RestController
@RequestMapping("producer")
public class ProducerController {

    @Autowired
    ProducerService producerService;

    @GetMapping
    public String healthCheck(@RequestBody String message){

        producerService.send(message);
        return "Message is sent succesfully";

    }

    @PostMapping
    public ProductDTO sendProductMessage(@RequestBody ProductDTO dto){
        producerService.send(dto);
        return dto;
    }


}