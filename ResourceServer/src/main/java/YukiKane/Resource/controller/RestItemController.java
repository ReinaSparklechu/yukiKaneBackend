package YukiKane.Resource.controller;

import YukiKane.Resource.domain.Item;
import YukiKane.Resource.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/item", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8081")
public class RestItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/{name}")
    public Item getItemByName(@PathVariable String name) {
        return itemRepository.findItemByName(name).blockLast();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item addNewItem(@RequestBody Item item) {
        return itemRepository.save(item).block();
    }

}
