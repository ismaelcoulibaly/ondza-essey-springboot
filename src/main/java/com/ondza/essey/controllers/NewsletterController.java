package com.ondza.essey.controllers;

import com.ondza.essey.entities.Subscriber;
import com.ondza.essey.repositories.ReservationRepository;
import com.ondza.essey.repositories.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/newsletter")
public class NewsletterController {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private ReservationRepository reservationRepository;
    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribe(@RequestParam String email) {
        if (subscriberRepository.findByEmail(email).isPresent()
        || reservationRepository.findFirstByEmail(email).isPresent()) {
            return ResponseEntity.badRequest().body("Email already subscribed");
        }

        Subscriber subscriber = new Subscriber();
        subscriber.setEmail(email);
        subscriberRepository.save(subscriber);
        return ResponseEntity.ok("Subscribed successfully");
    }

    // Other newsletter-related endpoints (e.g., send newsletters)
}
