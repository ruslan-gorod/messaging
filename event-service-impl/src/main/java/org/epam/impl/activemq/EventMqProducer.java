package org.epam.impl.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import org.epam.EventMessaging;
import org.epam.model.Event;

@Component
@Profile("active")
public class EventMqProducer implements EventMessaging {

    @Autowired
    private JmsTemplate template;

    @Override
    public void createEvent(Event event) {
        template.convertAndSend(ActiveMqConfig.CREATE_QUEUE, "CREATING EVENT: " + event.toString());
    }

    @Override
    public void updateEvent(Event event) {
        template.convertAndSend(ActiveMqConfig.UPDATE_QUEUE, "UPDATING EVENT: " + event.toString());
    }

    @Override
    public void deleteEvent(Long id) {
        template.convertAndSend(ActiveMqConfig.DELETE_QUEUE, "DELETING EVENT: " + id);
    }
}
