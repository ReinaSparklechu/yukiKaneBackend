package YukiKane.controller;

import YukiKane.domain.Outlet;
import YukiKane.repository.OutletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
