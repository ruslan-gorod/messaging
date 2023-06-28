package org.epam.impl.kafka;

import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Profile("kafka")
public class EventKafkaConsumer {

    @KafkaListener(topics = "create-event-request", groupId = "kafka-group")
    public void createEvent(String message) {
        System.out.printf("Create message from Kafka: {}%n", message);
    }

    @KafkaListener(topics = "update-event-request", groupId = "kafka-group")
    public void updateEvent(String message) {
        System.out.printf("Update message from Kafka: {}%n", message);
    }

    @KafkaListener(topics = "delete-event-request", groupId = "kafka-group")
    public void deleteEvent(Long id) {
        System.out.printf("Delete message from Kafka: {}%n", id);
    }
}
