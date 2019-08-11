package eShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/eShop", "/eShop/home"})
    public String homeIndex() {
        return "home/index";
    }

}
