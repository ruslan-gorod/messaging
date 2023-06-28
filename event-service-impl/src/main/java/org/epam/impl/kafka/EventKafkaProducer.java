package org.epam.impl.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import org.epam.EventMessaging;
import org.epam.model.Event;

@Component
@Profile("kafka")
public class EventKafkaProducer implements EventMessaging {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void createEvent(Event event) {
        kafkaTemplate.send("create-event-notification", "Creating event: " + event.toString());
    }

    @Override
    public void updateEvent(Event event) {
        kafkaTemplate.send("create-event-notification", "Updating event: " + event.toString());
    }

    @Override
    public void deleteEvent(Long id) {
        kafkaTemplate.send("create-event-notification", "Removing event with id: " + id);
    }
}
