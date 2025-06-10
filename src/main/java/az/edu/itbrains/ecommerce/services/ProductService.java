package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.dtos.product.ProductCreateDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductDashboardDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductUpdateDto;

import java.util.List;

public interface ProductService {
    List<ProductDashboardDto> getDashboardProducts();

    boolean createProduct(ProductCreateDto productCreateDto);

    ProductUpdateDto getUpdatedProduct(Long id);

    boolean updateProduct(Long id, ProductUpdateDto productUpdateDto);

    boolean removeProduct(Long id);
}
