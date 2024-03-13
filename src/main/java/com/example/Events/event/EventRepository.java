package com.example.Events.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface EventRepository extends JpaRepository<com.example.Events.event.Event, Long> {
    @Query("SELECT s FROM Event s WHERE s.contactInfo =?1")
    Optional<com.example.Events.event.Event> findEventByContactInfo(String contactInfo);
}
