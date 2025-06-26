package az.edu.itbrains.ecommerce.controllers;

import az.edu.itbrains.ecommerce.dtos.category.CategoryShopDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductShopDto;
import az.edu.itbrains.ecommerce.payloads.PaginationPayload;
import az.edu.itbrains.ecommerce.services.CategoryService;
import az.edu.itbrains.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ShopFilterController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/shop/filter")
    public ResponseEntity<PaginationPayload<ProductShopDto>> shopFilter(Model model, String searchTerm, Long categoryId, Long sort, Long minPrice, Integer currentPage){
        PaginationPayload<ProductShopDto> paginationPayload = productService.getShopProducts(searchTerm, categoryId, sort, minPrice, currentPage);


        return new ResponseEntity<>(paginationPayload, HttpStatus.OK);
    }
}
