package org.epam.impl;

import org.epam.EventMessaging;
import org.epam.EventService;
import org.epam.dto.EventDto;
import org.epam.model.Event;
import org.epam.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class EventServiceImpl implements EventService {

    private static final String EVENT_NOT_FOUND = "Event not found";

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private EventRepository repository;

    @Autowired(required = false)
    private EventMessaging messaging;

    @Override
    public EventDto createEvent(EventDto eventDto) {
        Event create = repository.save(mapToEntity(eventDto));
        messaging.createEvent(create);
        return mapToDto(create);
    }

    @Override
    public EventDto updateEvent(Long id, EventDto eventDto) {
        Event event = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(EVENT_NOT_FOUND));

        event.setTitle(eventDto.getTitle());
        event.setPlace(eventDto.getPlace());
        event.setSpeaker(eventDto.getSpeaker());
        event.setEventType(eventDto.getEventType());
        event.setDateTime(eventDto.getDateTime());

        Event update = repository.save(event);
        messaging.updateEvent(update);
        return mapToDto(update);
    }

    @Override
    public EventDto getEventById(Long id) {
        Event event = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(EVENT_NOT_FOUND));
        return mapToDto(event);
    }

    @Override
    public EventDto deleteEvent(Long id) {
        Event event = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(EVENT_NOT_FOUND));
        messaging.deleteEvent(id);
        repository.delete(event);
        return mapToDto(event);
    }

    @Override
    public List<EventDto> getAllEvents() {
        return repository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private Event mapToEntity(EventDto eventDto) {
        return mapper.map(eventDto, Event.class);
    }

    private EventDto mapToDto(Event event) {
        return mapper.map(event, EventDto.class);
    }
}
