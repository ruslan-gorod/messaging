package org.epam.impl.activemq;

import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Profile("active")
@EnableJms
public class EventMqConsumer {

    @JmsListener(destination = "create-event-request")
    public void createEventRequest(String message) {
        System.out.printf("Create message from ActiveMQ: {}%n", message);
    }

    @JmsListener(destination = "update-event-request")
    public void updateEventRequest(String message) {
        System.out.printf("Update message from ActiveMQ: {}%n", message);
    }

    @JmsListener(destination = "delete-event-request")
    public void deleteEventRequest(Long id) {
        System.out.printf("Delete message from ActiveMQ with id: {}%n", id);
    }
}
