package YukiKane.service;

import YukiKane.domain.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMessagingService  {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrder(Order o) {
        rabbitTemplate.convertAndSend(o.getOutlet().getId() ,o);
    }
}
