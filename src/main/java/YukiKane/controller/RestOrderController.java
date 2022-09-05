package YukiKane.controller;

import YukiKane.domain.Order;
import YukiKane.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8081")
public class RestOrderController {
    @Autowired
    private OrderRepository orderRepository;
    @PostMapping
    @ResponseStatus
    public Order placeOrder(@RequestBody Order order) {
        //Todo:this should send a message to the receiving store's end.
        return orderRepository.save(order).block();
    }
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable String id) {
        return orderRepository.findById(id).block();
    }
}
