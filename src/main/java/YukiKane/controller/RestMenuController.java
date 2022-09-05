package YukiKane.controller;

import YukiKane.domain.Item;
import YukiKane.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/menu", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8081")
public class RestMenuController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping
    public Flux<Item> menuItems() {
        var menu = new ArrayList<Item>();
        return itemRepository.findAll();



    }
    @GetMapping("/{tag}")
    public Flux<Item> findItems(@PathVariable String tag) {
        Logger.getGlobal().info("Tag is: " +tag);
        return itemRepository.findItemByName(tag);
    }
}
