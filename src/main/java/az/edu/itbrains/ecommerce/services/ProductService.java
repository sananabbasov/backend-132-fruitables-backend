package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.dtos.product.ProductCreateDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductDashboardDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductShopDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductUpdateDto;
import az.edu.itbrains.ecommerce.models.Product;
import az.edu.itbrains.ecommerce.payloads.PaginationPayload;

import java.util.List;

public interface ProductService {
    List<ProductDashboardDto> getDashboardProducts();

    boolean createProduct(ProductCreateDto productCreateDto);

    ProductUpdateDto getUpdatedProduct(Long id);

    boolean updateProduct(Long id, ProductUpdateDto productUpdateDto);

    boolean removeProduct(Long id);

    PaginationPayload<ProductShopDto> getShopProducts(String searchTerm, Long categoryId, Long sort, Long minPrice, Integer currentPage);

    Product findProductById(Long productId);
}
