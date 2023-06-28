package org.epam.impl.activemq;

import jakarta.jms.ConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@Configuration
@Profile(value = "active")
public class ActiveMqConfig {

    public static final String CREATE_QUEUE = "create-event-notification";
    public static final String DELETE_QUEUE = "delete-event-notification";
    public static final String UPDATE_QUEUE = "update-event-notification";

    @Bean
    public JmsListenerContainerFactory<?> factory(ConnectionFactory connectionFactory,
                                                  DefaultJmsListenerContainerFactoryConfigurer conf) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        conf.configure(factory, connectionFactory);
        return factory;
    }
}
