package YukiKane.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/outlet", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8081")
public class RestOutletController {
}
