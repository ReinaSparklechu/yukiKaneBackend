package YukiKane;

import YukiKane.domain.*;
import YukiKane.repository.*;
import com.google.cloud.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import reactor.core.publisher.Flux;

import java.io.Console;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@SpringBootTest
@EnableAutoConfiguration
@ContextConfiguration(classes = {UserRepository.class, ItemRepository.class, OrderRepository.class, OutletRepository.class, MenuRepository.class})
public class RepositoryTest {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OutletRepository outletRepository;
    @Autowired
    MenuRepository menuRepository;

    @Test
    @org.junit.jupiter.api.Order(1)
    public void setUpMenu() {

        itemRepository.deleteAll().block();
        userRepository.deleteAll().block();
        outletRepository.deleteAll().block();
        menuRepository.deleteAll().block();
        orderRepository.deleteAll().block();
        uploadItems();
        uploadUsers();
        uploadOutlet();
        uploadMenu();
    }
    @Test
    @org.junit.jupiter.api.Order(2)
    public void sendOrder(){
        var user = userRepository.findByName("Timmy").block();
        Logger.getGlobal().info(user.toString());
        var order = new Order();
        var outlet = outletRepository.findByAddress("Baker St 123").block();
        var menu = outlet.getMenu().getOfferings();
        order.setItems(Arrays.asList(menu.get(0)));
        order.setPlacedBy(user);
        order.setPlacedAt(Timestamp.now());
        order.setOutlet(outlet);
        orderRepository.save(order).block();
        Logger.getGlobal().info("order saved");
    }

    public void uploadItems() {
        var items = new ArrayList<Item>();
        items.add(new Item("Latte", "Espresso shots with frothed milk poured over. Topped with a thin layer of foamed milk"));
        items.add(new Item("Cappuccino", "Espresso shots with frothed milk poured over. Topped with a generous layer of foamed milk"));
        items.add(new Item("Brewed Coffee", "Coffee brewed the good old fashioned way using a drip brewer"));
        items.add(new Item("Flat White", "Espresso shots with hot milk"));
        items.add(new Item("Mocha", "Chocolate and espresso shot with steamed milk poured over. Rich and chocolatey"));
        items.add(new Item("Americano", "Espresso shots diluted with water to resemble a brewed coffee"));
        items.add(new Item("White Mocha", "White chocolate and espresso shot with steamed milk poured over. Sweet and creamy"));
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

    public void uploadOutlet() {
        var outlets = new ArrayList<Outlet>();
        outlets.add(new Outlet());
        var outlet1 = outlets.get(0);
        outlet1.setAddress("Baker_St_123");
        outlet1.setMaxOrders(20);
        var outlet2 = new Outlet();
        outlet2.setAddress("4_Picket_Drive");
        outlet2.setMaxOrders(30);
        outlets.add(outlet2);
        outletRepository.saveAll(outlets).blockLast();
    }
    public void uploadMenu() {
        var menus = new ArrayList<Menu>();
        var menu1 = new Menu();
        var menu2 = new Menu();
        var items = itemRepository.findAll().collectList().block();
        menu1.setOfferings(items);
        var items2 = items.stream().filter(item -> item.getName()!="Brewed Coffee").collect(Collectors.toList());
        Logger.getGlobal().info(Arrays.deepToString(items2.toArray()));
        menu2.setOfferings(items2);
        var outlet = outletRepository.findByAddress("Baker_St_123").block();
        outlet.setMenu(menu1);
        outletRepository.save(outlet).block();
        menus.add(menu1);
        menus.add(menu2);
        menuRepository.saveAll(menus).doOnComplete(()-> Logger.getGlobal().info("Menus saved")).blockLast();
    }
}
