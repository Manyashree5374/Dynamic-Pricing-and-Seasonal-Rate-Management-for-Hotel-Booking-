package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Booking;
import com.examly.springapp.repository.BookingRepo;
import java.util.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingRepo booking;

    @GetMapping
    public List<Booking> getAllBookings() {
        return booking.findAll();
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking newBooking) {
        return booking.save(newBooking);
    }

    @DeleteMapping("/{bookingid}")
    public String deleteroom(@PathVariable Long bookingid){
        booking.deleteById(bookingid);
        return "user deleted";
    } 
}
