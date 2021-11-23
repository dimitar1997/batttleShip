package com.example.batttleship.repository;

import com.example.batttleship.models.entity.Ship;
import com.example.batttleship.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    List<Ship> findAllByUser(User user);
    @Query("select s from Ship s order by s.id,s.health,s.power")
    List<Ship> findAllByOrderByIdAndHealthPower();
}
