package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Room;
import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.repository.RoomRepo;
import com.examly.springapp.repository.RoomCategoryRepo;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl {
    
    @Autowired
    private RoomRepo roomRepo;
    
    @Autowired
    private RoomCategoryRepo roomCategoryRepo;
    
    public Room addRoom(Room room) {
        if (room.getRoomCategory() != null) {
            RoomCategory category = null;
            
            if (room.getRoomCategory().getCategoryName() != null) {
                String name = room.getRoomCategory().getCategoryName();
                category = roomCategoryRepo.findByCategoryName(name)
                        .orElseGet(() -> {
                            RoomCategory c = new RoomCategory();
                            c.setCategoryName(name);
                            return roomCategoryRepo.save(c);
                        });
            } else if (room.getRoomCategory().getCategoryId() != null) {
                Long categoryId = room.getRoomCategory().getCategoryId();
                category = roomCategoryRepo.findById(categoryId).orElse(null);
            }
            
            room.setRoomCategory(category);
        }
        return roomRepo.save(room);
    }
    
    public Room updateRoom(Long id, Room room) {
        room.setRoomId(id);
        
        if (room.getRoomCategory() != null) {
            RoomCategory category = null;
            
            if (room.getRoomCategory().getCategoryName() != null) {
                String name = room.getRoomCategory().getCategoryName();
                category = roomCategoryRepo.findByCategoryName(name)
                        .orElseGet(() -> {
                            RoomCategory c = new RoomCategory();
                            c.setCategoryName(name);
                            return roomCategoryRepo.save(c);
                        });
            } else if (room.getRoomCategory().getCategoryId() != null) {
                Long categoryId = room.getRoomCategory().getCategoryId();
                category = roomCategoryRepo.findById(categoryId).orElse(null);
            }
            
            room.setRoomCategory(category);
        }
        return roomRepo.save(room);
    }
    
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }
    
    public Optional<Room> getRoomById(Long id) {
        return roomRepo.findById(id);
    }
    
    public List<Room> getRoomByNumber(String roomNumber) {
        return roomRepo.findByRoomNumber(roomNumber);
    }
    
    public List<Room> getRoomsByCategoryName(String categoryName) {
        return roomRepo.findRoomsByCategoryName(categoryName);
    }
}
