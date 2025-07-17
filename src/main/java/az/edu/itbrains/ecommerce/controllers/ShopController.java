package az.edu.itbrains.ecommerce.controllers;

import az.edu.itbrains.ecommerce.dtos.basket.BasketAddDto;
import az.edu.itbrains.ecommerce.dtos.basket.BasketDto;
import az.edu.itbrains.ecommerce.dtos.category.CategoryShopDto;
import az.edu.itbrains.ecommerce.dtos.order.OrderUserDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductShopDto;
import az.edu.itbrains.ecommerce.dtos.user.UserDto;
import az.edu.itbrains.ecommerce.payloads.PaginationPayload;
import az.edu.itbrains.ecommerce.services.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ShopController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final BasketService basketService;
    private final OrderService orderService;
    private final UserService userService;

    @GetMapping("/shop")
    public String shop(Model model, String searchTerm,Long categoryId, Long sort, Long minPrice, Integer currentPage, @RequestParam Map<String,String> allParams){
        PaginationPayload<ProductShopDto> paginationPayload = productService.getShopProducts(searchTerm, categoryId, sort, minPrice, currentPage);
        List<CategoryShopDto> categories = categoryService.getShopCatgories();
        model.addAttribute("products", paginationPayload);
        model.addAttribute("categories", categories);

        return "shop.html";
    }



    @GetMapping("/cart")
    @PreAuthorize("isAuthenticated()")
    public String cart(Model model, Principal principal){

        String userEmail = principal.getName();
        List<BasketDto> basketDtoList = basketService.getUserBaskets(userEmail);

        model.addAttribute("baskets", basketDtoList);

        return "cart.html";
    }


    @PostMapping("/cart")
    @PreAuthorize("isAuthenticated()")
    public String cart(BasketAddDto basketAddDto, Principal principal){
        String userEmail = principal.getName();
        basketService.addToCart(basketAddDto, userEmail);
        return "redirect:/cart";
    }


    @GetMapping("/checkout")
    @PreAuthorize("isAuthenticated()")
    public String checkout(Model model, Principal principal){

        String userEmail = principal.getName();
        List<BasketDto> basketDtoList = basketService.getUserBaskets(userEmail);
        UserDto userDto = userService.findUserDtoByEmail(userEmail);
        model.addAttribute("user", userDto);
        model.addAttribute("baskets", basketDtoList);
        return "checkout.html";
    }


    @PostMapping("/checkout")
    @PreAuthorize("isAuthenticated()")
    public String checkout(OrderUserDto orderUserDto, Principal principal){

        String userEmail = principal.getName();
        boolean result = orderService.orderProduct(userEmail, orderUserDto);

        return "redirect:/";
    }

    @GetMapping("/shop/detail/{id}")
    public String detail(){
        return "detail.html";
    }


    @GetMapping("/cart/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String delete(@PathVariable Long id){

        basketService.removeBasketItem(id);

        return "redirect:/cart";
    }

}
