package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.repository.RoomCategoryRepo;
import java.util.List;
import java.util.Optional;

@Service
public class RoomCategoryServiceImpl {
    
    @Autowired
    private RoomCategoryRepo roomCategoryRepo;
    
    public RoomCategory createCategory(RoomCategory category) {
        return roomCategoryRepo.save(category);
    }
    
    public List<RoomCategory> getAllCategories() {
        return roomCategoryRepo.findAll();
    }
    
    public Optional<RoomCategory> getCategoryById(Long id) {
        return roomCategoryRepo.findById(id);
    }
    
    public RoomCategory updateCategory(Long id, RoomCategory category) {
        category.setCategoryId(id);
        return roomCategoryRepo.save(category);
    }
    
    public void deleteCategory(Long id) {
        roomCategoryRepo.deleteById(id);
    }
    
    public Page<RoomCategory> getPaginatedCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("categoryId").ascending());
        return roomCategoryRepo.findAll(pageable);
    }
}
