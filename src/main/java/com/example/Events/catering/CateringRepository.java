package com.example.Events.catering;

import com.example.Events.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CateringRepository extends JpaRepository<Catering, Long> {
}
