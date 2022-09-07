package YukiKane.Resource.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8081")
public class RestUserController {
}
