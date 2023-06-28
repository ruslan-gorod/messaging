package org.epam;

import org.epam.model.Event;

public interface EventMessaging {

    void createEvent(Event event);

    void updateEvent(Event event);

    void deleteEvent(Long id);
}
