package com.examly.springapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.Room;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room r JOIN r.roomCategory c WHERE c.categoryName = :categoryName")
    List<Room> findRoomsByCategoryName(@Param("categoryName") String categoryName);
    List<Room> findByRoomNumber(String roomNumber);
}

