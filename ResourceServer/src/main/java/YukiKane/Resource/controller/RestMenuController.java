package YukiKane.Resource.controller;

import YukiKane.Resource.domain.Menu;
import YukiKane.Resource.repository.MenuRepository;


import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/menu", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8081")
public class RestMenuController {
    @Autowired
    MenuRepository menuRepository;

    @PatchMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Menu updateMenu(@RequestBody Menu menu) throws HttpException {
        try {
            return menuRepository.save(menu).block();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new HttpException("Something's wrong i can feel it");

    }
}
