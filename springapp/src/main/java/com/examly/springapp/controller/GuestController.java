package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Guest;
import com.examly.springapp.repository.GuestRepo;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    @Autowired
    private GuestRepo guestRepo;

    @PostMapping
    public ResponseEntity<Guest> addGuest(@RequestBody Guest guest) {
        return new ResponseEntity<>(guestRepo.save(guest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuests() {
        return ResponseEntity.ok(guestRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
        return ResponseEntity.ok(guestRepo.findById(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(
            @PathVariable Long id,
            @RequestBody Guest guest) {

        guest.setGuestId(id);
        return ResponseEntity.ok(guestRepo.save(guest));
    }

    @GetMapping("/email/{email}")
    public List<Guest> getGuestByEmail(@PathVariable String email) {
        return guestRepo.findByEmail(email);
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<?> getGuestByPhone(@PathVariable String phone) {
        List<Guest> guests = guestRepo.findByPhone(phone);

        if (guests.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No guest found with phone: " + phone);
        }

        return ResponseEntity.ok(guests);
    }

}