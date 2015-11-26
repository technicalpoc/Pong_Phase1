package org.bk.producer.controller;


import org.bk.producer.domain.Message;
import org.bk.producer.domain.MessageAcknowledgement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@ComponentScan
@RestController
@RefreshScope
public class PongController {

    @Value("${reply.message}")
    private String message;

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public Resource<MessageAcknowledgement> pongMessage(@RequestBody Message input) {
    	 
    	System.out.println("PongController - input : "+input);
    	System.out.println("input.getId() : "+ input.getPayload());
    	
        return new Resource<>(
                new MessageAcknowledgement(input.getId(), input.getPayload(), message));
    }



}
