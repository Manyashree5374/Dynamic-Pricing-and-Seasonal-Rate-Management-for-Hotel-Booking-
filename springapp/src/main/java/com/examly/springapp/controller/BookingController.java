package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.repository.BookingRepo;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingRepo booking;
    
    @DeleteMapping("/{bookingid}")
    public String deleteroom(@PathVariable Long bookingid){
        booking.deleteById(bookingid);
        return "user deleted";
    } 
}
