package az.edu.itbrains.ecommerce.repositories;

import az.edu.itbrains.ecommerce.dtos.category.CategoryShopDto;
import az.edu.itbrains.ecommerce.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByNameIgnoreCase(String name);

    @Query(nativeQuery = true,value = "SELECT * FROM shopCategories")
    List<CategoryShopDto> getPopularCategories();
}
