package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Room;
import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.repository.RoomRepo;
import com.examly.springapp.repository.RoomCategoryRepo;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private RoomCategoryRepo roomCategoryRepo;

    @PostMapping
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {

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
            }
            
            else if (room.getRoomCategory().getCategoryId() != null) {
                Long categoryId = room.getRoomCategory().getCategoryId();
                category = roomCategoryRepo.findById(categoryId).orElse(null);
            }
            
            room.setRoomCategory(category);
        }

        return new ResponseEntity<>(roomRepo.save(room), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(
            @PathVariable Long id,
            @RequestBody Room room) {

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
            }
            
            else if (room.getRoomCategory().getCategoryId() != null) {
                Long categoryId = room.getRoomCategory().getCategoryId();
                category = roomCategoryRepo.findById(categoryId).orElse(null);
            }
            
            room.setRoomCategory(category);
        }

        return ResponseEntity.ok(roomRepo.save(room));
    }


    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable Long id) {

        Room room = roomRepo.findById(id).orElse(null);

        if (room == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Room not found");
        }

        return ResponseEntity.ok(room);
    }

    @GetMapping("/number/{roomNumber}")
    public ResponseEntity<?> getRoomByNumber(
            @PathVariable String roomNumber) {

        List<Room> rooms = roomRepo.findByRoomNumber(roomNumber);

        if (rooms.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No room found with number: " + roomNumber);
        }

        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Room>> getRoomsByCategoryName(@PathVariable String categoryName) {
        return ResponseEntity.ok(roomRepo.findRoomsByCategoryName(categoryName));
    }

}