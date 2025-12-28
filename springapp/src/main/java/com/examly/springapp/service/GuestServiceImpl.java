package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Guest;
import com.examly.springapp.repository.GuestRepo;
import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl {
    
    @Autowired
    private GuestRepo guestRepo;
    
    public Guest addGuest(Guest guest) {
        return guestRepo.save(guest);
    }
    
    public List<Guest> getAllGuests() {
        return guestRepo.findAll();
    }
    
    public Optional<Guest> getGuestById(Long id) {
        return guestRepo.findById(id);
    }
    
    public Guest updateGuest(Long id, Guest guest) {
        guest.setGuestId(id);
        return guestRepo.save(guest);
    }
    
    public List<Guest> getGuestByEmail(String email) {
        return guestRepo.findByEmail(email);
    }
    
    public List<Guest> getGuestByPhone(String phone) {
        return guestRepo.findByPhone(phone);
    }
}
