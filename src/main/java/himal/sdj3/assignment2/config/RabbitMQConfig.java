package himal.sdj3.assignment2.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
        @Bean
    public Exchange orderExchange(){
            return new DirectExchange("order.Exchange");
        }

        @Bean
    public Queue orderQueue(){
            return  new Queue("order.Queue");
        }

        @Bean
    public Binding binding(){
            return  BindingBuilder.bind(orderQueue()).to(orderExchange()).with("orderRoutingKey").noargs();
        }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
