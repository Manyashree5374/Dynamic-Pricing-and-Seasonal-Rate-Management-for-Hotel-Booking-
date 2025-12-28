package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Booking;
import com.examly.springapp.repository.BookingRepo;
import java.util.List;

@Service
public class BookingServiceImpl {
    
    @Autowired
    private BookingRepo bookingRepo;
    
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }
    
    public Booking createBooking(Booking booking) {
        return bookingRepo.save(booking);
    }
    
    public void deleteBooking(Long bookingId) {
        bookingRepo.deleteById(bookingId);
    }
}
