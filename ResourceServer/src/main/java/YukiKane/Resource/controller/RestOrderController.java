package YukiKane.Resource.controller;


import YukiKane.Resource.domain.Order;
import YukiKane.Resource.repository.OrderRepository;
import com.google.gson.annotations.JsonAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping(path = "/order", produces = "application/json")
@CrossOrigin(origins = "http://localhost:9090")
public class RestOrderController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(consumes="application/json")
    // todo: change to only receive array of items and outlet name.
    public Order placeOrder(@RequestBody Order order ) {
        System.out.println(order);
        //Todo:this should send a message to the receiving store's end, this should also update the order list in an outlet
        return new Order();
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
