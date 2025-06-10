package az.edu.itbrains.ecommerce.controllers.dashboard;


import az.edu.itbrains.ecommerce.dtos.category.CategoryCreateDto;
import az.edu.itbrains.ecommerce.dtos.category.CategoryDashboardDto;
import az.edu.itbrains.ecommerce.dtos.category.CategoryUpdateDto;
import az.edu.itbrains.ecommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/dashboard/categories")
    public String index(Model model){
        List<CategoryDashboardDto> categoryDashboardDtoList = categoryService.getDashboardCategories();
        model.addAttribute("categories", categoryDashboardDtoList);
        return "dashboard/category/index.html";
    }

    @GetMapping("/dashboard/category/create")
    public String create(){
        return "dashboard/category/create.html";
    }


    @PostMapping("/dashboard/category/create")
    public String create(CategoryCreateDto categoryCreateDto){
        boolean result = categoryService.createCategory(categoryCreateDto);
        if (result){
            return "redirect:/dashboard/categories";
        }
        return "dashboard/category/create.html";
    }


    @GetMapping("/dashboard/category/update/{id}")
    public String update(@PathVariable Long id, Model model){
        CategoryUpdateDto categoryUpdateDto = categoryService.getUpdatedCategory(id);
        model.addAttribute("category", categoryUpdateDto);
        return "dashboard/category/update.html";
    }

    @PostMapping("/dashboard/category/update/{id}")
    public String update(@PathVariable Long id, CategoryUpdateDto categoryUpdateDto){
        boolean result = categoryService.updateCategory(id, categoryUpdateDto);
        if (result){
            return "redirect:/dashboard/categories";
        }
        return "dashboard/category/update.html";

    }


    @GetMapping("/dashboard/category/delete/{id}")
    public String remove(@PathVariable Long id, Model model){
        CategoryUpdateDto categoryUpdateDto = categoryService.getUpdatedCategory(id);
        model.addAttribute("category", categoryUpdateDto);
        return "dashboard/category/delete.html";
    }

    @PostMapping("/dashboard/category/delete/{id}")
    public String remove(@PathVariable Long id){
        boolean result = categoryService.removeCategory(id);
        if (result){
            return "redirect:/dashboard/categories";
        }
        return "dashboard/category/delete.html";
    }


}
