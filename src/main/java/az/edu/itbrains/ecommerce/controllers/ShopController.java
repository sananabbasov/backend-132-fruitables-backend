package az.edu.itbrains.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

    @GetMapping("/shop")
    public String shop(){
        return "shop.html";
    }


    @GetMapping("/cart")
    public String cart(){
        return "cart.html";
    }


    @GetMapping("/checkout")
    public String checkout(){
        return "checkout.html";
    }

    @GetMapping("/shop/detail/{id}")
    public String detail(){
        return "detail.html";
    }


}
