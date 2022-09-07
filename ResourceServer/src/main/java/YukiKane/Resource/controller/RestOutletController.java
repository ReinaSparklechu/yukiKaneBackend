package YukiKane.Resource.controller;

import YukiKane.Resource.domain.Order;
import YukiKane.Resource.domain.Outlet;
import YukiKane.Resource.repository.OutletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/outlet", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8081")
public class RestOutletController {
    @Autowired
    OutletRepository outletRepository;

    @GetMapping("/{addr}")
    public Outlet getOutlet(@PathVariable String addr) {

        var outlet =outletRepository.findByAddress(addr).block();
        Logger.getGlobal().info(outlet.toString());
        return outlet;
    }
    //todo: instead of updating the whole menu, we should insert a method into outlet that allows for the adding and removing of an order using an order parameter
    @PatchMapping("update/{outletId}")
    public Outlet updateQueue(@PathVariable String outletId, @RequestBody List<Order> orders){
        var outlet = outletRepository.findById(outletId).block();
        outlet.setQueuedOrders(orders);
        return outletRepository.save(outlet).block();
    }
}
