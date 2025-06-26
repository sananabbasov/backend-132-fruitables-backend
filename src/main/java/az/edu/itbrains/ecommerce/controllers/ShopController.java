package az.edu.itbrains.ecommerce.controllers;

import az.edu.itbrains.ecommerce.dtos.category.CategoryShopDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductShopDto;
import az.edu.itbrains.ecommerce.payloads.PaginationPayload;
import az.edu.itbrains.ecommerce.services.CategoryService;
import az.edu.itbrains.ecommerce.services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ShopController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/shop")
    public String shop(Model model, String searchTerm,Long categoryId, Long sort, Long minPrice, Integer currentPage, @RequestParam Map<String,String> allParams){
        PaginationPayload<ProductShopDto> paginationPayload = productService.getShopProducts(searchTerm, categoryId, sort, minPrice, currentPage);
        List<CategoryShopDto> categories = categoryService.getShopCatgories();
        model.addAttribute("products", paginationPayload);
        model.addAttribute("categories", categories);

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
