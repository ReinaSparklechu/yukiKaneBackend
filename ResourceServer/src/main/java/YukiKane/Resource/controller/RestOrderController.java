package YukiKane.Resource.controller;


import YukiKane.Resource.domain.Order;
import YukiKane.Resource.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        //Todo:this should send a message to the receiving store's end, this should also update the order list in an outlet
        return orderRepository.save(order).block();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable String id) {
        return orderRepository.findById(id).block();
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public Order editOrder(@RequestBody Order order) {
       return orderRepository.save(order).block();
    }
}
