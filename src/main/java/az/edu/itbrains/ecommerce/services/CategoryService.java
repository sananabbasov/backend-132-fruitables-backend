package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.dtos.category.CategoryCreateDto;
import az.edu.itbrains.ecommerce.dtos.category.CategoryDashboardDto;
import az.edu.itbrains.ecommerce.dtos.category.CategoryUpdateDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDashboardDto> getDashboardCategories();

    boolean createCategory(CategoryCreateDto categoryCreateDto);

    CategoryUpdateDto getUpdatedCategory(Long id);

    boolean updateCategory(Long id, CategoryUpdateDto categoryUpdateDto);

    boolean removeCategory(Long id);
}
