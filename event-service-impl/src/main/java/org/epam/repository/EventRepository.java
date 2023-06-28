package org.epam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.epam.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
