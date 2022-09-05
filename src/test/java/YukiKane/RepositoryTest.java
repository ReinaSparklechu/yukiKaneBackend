package YukiKane;

import YukiKane.domain.Item;
import YukiKane.domain.Order;
import YukiKane.domain.User;
import YukiKane.repository.ItemRepository;
import YukiKane.repository.OrderRepository;
import YukiKane.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import reactor.core.publisher.Flux;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

@SpringBootTest
@EnableAutoConfiguration
@ContextConfiguration(classes = {UserRepository.class, ItemRepository.class, OrderRepository.class})
public class RepositoryTest {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void test() {
        itemRepository.deleteAll().block();
        orderRepository.deleteAll().block();
        userRepository.deleteAll().block();
        userRepository.save(new User ("Timmy" , 25)).block();
        userRepository.save(new User("Sammy" , 25)).block();
        userRepository.save((new User("Jacob", 18))).block();
        Item item = new Item("Vanilla Frappe");
        itemRepository.save(item).block();
        Flux<User> allUsers = userRepository.findAll();
        allUsers.doOnNext(user -> Logger.getGlobal().info(user.toString())).doOnComplete(() -> Logger.getGlobal().info("Done")).blockLast();
        User cust = userRepository.findByName("Timmy").blockFirst();
        Logger.getGlobal().info(cust.toString());
        Order order = new Order();
        order.setU(cust);
        order.setItems(Arrays.asList(item));
        orderRepository.save(order).block();
        var orders = orderRepository.findAll();
        orders.doOnNext(order1 -> Logger.getGlobal().info(order1.toString())).doOnComplete(() -> Logger.getGlobal().info("Order saved")).blockLast();

    }
    @Test
    public void setUpMenu() {

        itemRepository.deleteAll().block();
        uploadItems();
        uploadUsers();
    }
    public void uploadItems() {
        var items = new ArrayList<Item>();
        items.add(new Item("Latte", "Espresso shots with frothed milk poured over. Topped with a thin layer of foamed milk"));
        items.add(new Item("Cappuccino", "Espresso shots with frothed milk poured over. Topped with a generous layer of foamed milk"));
        items.add(new Item("Brewed Coffee", "Coffee brewed the good old fashioned way using a drip brewer"));
        items.add(new Item("Flat White", "Espresso shots with hot milk"));
        items.add(new Item("Mocha", "Chocolate and espresso shot with steamed milk poured over. Rich and chocolatey"));
        items.add(new Item("Americano", "Espresso shots diluted with water to resemble a brewed coffee"));
        items.add(new Item("White Mocha", "White chocolate and espresso shot with steamed milk poured over. Sweet and creamy :milk: "));
        itemRepository.saveAll(items).blockLast();


    }
    public void uploadUsers(){
        var users = new ArrayList<User>();
        users.add(new User("Timmy", 25));
        users.add(new User("James",32));
        users.add(new User("Jane", 21));
        users.add(new User("Mary", 18));
        users.add(new User("Anthony", 19));
        userRepository.saveAll(users).doOnComplete(()-> Logger.getGlobal().info("Saved all")).blockLast();
    }
}
