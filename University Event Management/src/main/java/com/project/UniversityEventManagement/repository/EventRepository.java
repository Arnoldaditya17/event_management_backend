package com.project.UniversityEventManagement.repository;

import com.project.UniversityEventManagement.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByDateBefore(LocalDate date);
}