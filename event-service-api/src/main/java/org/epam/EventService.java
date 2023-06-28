package org.epam;

import java.util.List;

import org.epam.dto.EventDto;

public interface EventService {

    EventDto createEvent(EventDto event);

    EventDto updateEvent(Long id, EventDto event);

    EventDto getEventById(Long id);

    EventDto deleteEvent(Long id);

    List<EventDto> getAllEvents();
}
