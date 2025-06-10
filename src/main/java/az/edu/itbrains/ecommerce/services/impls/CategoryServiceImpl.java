package az.edu.itbrains.ecommerce.services.impls;

import az.edu.itbrains.ecommerce.dtos.category.CategoryCreateDto;
import az.edu.itbrains.ecommerce.dtos.category.CategoryDashboardDto;
import az.edu.itbrains.ecommerce.dtos.category.CategoryUpdateDto;
import az.edu.itbrains.ecommerce.models.Category;
import az.edu.itbrains.ecommerce.repositories.CategoryRepository;
import az.edu.itbrains.ecommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<CategoryDashboardDto> getDashboardCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDashboardDto> categoryDashboardDtoList = categories.stream().map(category -> modelMapper.map(category, CategoryDashboardDto.class)).toList();
        return categoryDashboardDtoList;
    }

    @Override
    public boolean createCategory(CategoryCreateDto categoryCreateDto) {
        return false;
    }

    @Override
    public CategoryUpdateDto getUpdatedCategory(Long id) {
        return null;
    }

    @Override
    public boolean updateCategory(Long id, CategoryUpdateDto categoryUpdateDto) {
        return false;
    }

    @Override
    public boolean removeCategory(Long id) {
        return false;
    }
}
