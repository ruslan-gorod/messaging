package org.epam.impl.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Profile("rabbitmq")
public class EventRabbitMqConsumer {

    @RabbitListener(queues = "create-event-request")
    public void createEvent(Message message) {
        System.out.printf("Create Event message from RabbitMQ: {}%n", Arrays.toString(message.getBody()));
    }

    @RabbitListener(queues = "update-event-request")
    public void updateEvent(Message message) {
        System.out.printf("Update Event message from RabbitMQ: {}%n", Arrays.toString(message.getBody()));
    }

    @RabbitListener(queues = "delete-event-request")
    public void deleteEvent(Message message) {
        System.out.printf("Delete message from RabbitMQ: {}%n", Arrays.toString(message.getBody()));
    }
}
