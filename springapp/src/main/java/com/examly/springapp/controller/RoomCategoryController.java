package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.repository.RoomCategoryRepo;

@RestController
@RequestMapping("/api/room-categories")
public class RoomCategoryController {

    @Autowired
    private RoomCategoryRepo roomCategoryRepo;

    
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody(required = false) RoomCategory category) {
        if (category == null) {
            return ResponseEntity.badRequest().build();
        }
        RoomCategory saved = roomCategoryRepo.save(category);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

   
    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        List<RoomCategory> list = roomCategoryRepo.findAll();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    
    @GetMapping("/{id}")
     public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
    RoomCategory category = roomCategoryRepo.findById(id).orElse(null);
    if (category == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Room category not found");
    }
    return ResponseEntity.ok(category);
}



    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(
            @PathVariable Long id,
            @RequestBody RoomCategory category) {

        category.setCategoryId(id);
        return ResponseEntity.ok(roomCategoryRepo.save(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    
    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<RoomCategory>> getPaginatedCategories(
            @PathVariable int page,
            @PathVariable int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("categoryId").ascending());
        Page<RoomCategory> result = roomCategoryRepo.findAll(pageable);

        return ResponseEntity.ok(result);
    }

   
}

