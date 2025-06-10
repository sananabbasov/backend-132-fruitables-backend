package az.edu.itbrains.ecommerce.controllers.dashboard;

import az.edu.itbrains.ecommerce.dtos.product.ProductCreateDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductDashboardDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductUpdateDto;
import az.edu.itbrains.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/dashboard/categories")
    public String index(Model model){
        List<ProductDashboardDto> productDashboardDtoList = productService.getDashboardProducts();
        model.addAttribute("categories", productDashboardDtoList);
        return "dashboard/product/index.html";
    }

    @GetMapping("/dashboard/product/create")
    public String create(){
        return "dashboard/product/create.html";
    }


    @PostMapping("/dashboard/product/create")
    public String create(ProductCreateDto productCreateDto){
        boolean result = productService.createProduct(productCreateDto);
        if (result){
            return "redirect:/dashboard/categories";
        }
        return "dashboard/product/create.html";
    }


    @GetMapping("/dashboard/product/update/{id}")
    public String update(@PathVariable Long id, Model model){
        ProductUpdateDto productUpdateDto = productService.getUpdatedProduct(id);
        model.addAttribute("product", productUpdateDto);
        return "dashboard/product/update.html";
    }

    @PostMapping("/dashboard/product/update/{id}")
    public String update(@PathVariable Long id, ProductUpdateDto productUpdateDto){
        boolean result = productService.updateProduct(id, productUpdateDto);
        if (result){
            return "redirect:/dashboard/categories";
        }
        return "dashboard/product/update.html";

    }


    @GetMapping("/dashboard/product/delete/{id}")
    public String remove(@PathVariable Long id, Model model){
        ProductUpdateDto productUpdateDto = productService.getUpdatedProduct(id);
        model.addAttribute("product", productUpdateDto);
        return "dashboard/product/delete.html";
    }

    @PostMapping("/dashboard/product/delete/{id}")
    public String remove(@PathVariable Long id){
        boolean result = productService.removeProduct(id);
        if (result){
            return "redirect:/dashboard/categories";
        }
        return "dashboard/product/delete.html";
    }
}
