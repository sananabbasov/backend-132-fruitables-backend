package az.edu.itbrains.ecommerce.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {


    @GetMapping("/")
    public String index(){
        return "index.html";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact.html";
    }


}
