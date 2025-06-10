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
        try {
            Category findCategory = categoryRepository.findByNameIgnoreCase(categoryCreateDto.getName());
            if (findCategory != null){
                return false;
            }
            Category category = new Category();
            category.setName(categoryCreateDto.getName());
            categoryRepository.save(category);
            return true;
        }catch (Exception e){
            return  false;
        }
    }

    @Override
    public CategoryUpdateDto getUpdatedCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        if (category == null){
            return null;
        }
        CategoryUpdateDto categoryUpdateDto = modelMapper.map(category, CategoryUpdateDto.class);
        return categoryUpdateDto;
    }

    @Override
    public boolean updateCategory(Long id, CategoryUpdateDto categoryUpdateDto) {
        try {
            Category category = categoryRepository.findById(id).orElseThrow();
            category.setName(categoryUpdateDto.getName());
            categoryRepository.save(category);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean removeCategory(Long id) {
        try {
            Category category = categoryRepository.findById(id).orElseThrow();
            categoryRepository.delete(category);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
