package com.ondza.essey.controllers;

import com.ondza.essey.entities.Subscriber;
import com.ondza.essey.repositories.SubscriberRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/newsletter")
@CrossOrigin(origins = "*")
public class NewsletterController {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @ApiResponse(responseCode = "200", description = "The email has successfully been registered")
    @ApiResponse(responseCode = "400", description = "Not found")
    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribe(@RequestParam String email) {
        if (subscriberRepository.findByEmail(email).isPresent()) {
            return ResponseEntity.badRequest().body("Email already subscribed");
        }

        Subscriber subscriber = new Subscriber();
        subscriber.setEmail(email);
        subscriberRepository.save(subscriber);
        return ResponseEntity.ok("Subscribed successfully");
    }
}
