package YukiKane.Resource.service;

import YukiKane.Resource.domain.Order;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitOrderMessageService {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitOrderMessageService(RabbitTemplate rabbitTemplate) {
        System.out.println("Rabbit service online!");
        this.rabbitTemplate=rabbitTemplate;
    }

    public void sendOrder(Order order) {
        MessageConverter converter= rabbitTemplate.getMessageConverter();
        MessageProperties properties = new MessageProperties();
        Message message=converter.toMessage(order,properties);
        rabbitTemplate.send("YukiKane.order", message);
    }
}
