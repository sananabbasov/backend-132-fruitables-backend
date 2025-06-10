package az.edu.itbrains.ecommerce.services.impls;

import az.edu.itbrains.ecommerce.dtos.product.ProductCreateDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductDashboardDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductUpdateDto;
import az.edu.itbrains.ecommerce.models.Product;
import az.edu.itbrains.ecommerce.repositories.ProductRepository;
import az.edu.itbrains.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<ProductDashboardDto> getDashboardProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDashboardDto> productDashboardDtoList = products.stream().map(product -> modelMapper.map(product, ProductDashboardDto.class)).toList();
        return productDashboardDtoList;
    }

    @Override
    public boolean createProduct(ProductCreateDto productCreateDto) {
        try {

            Product product = new Product();
//            product.setName(productCreateDto.getName());
            productRepository.save(product);
            return true;
        }catch (Exception e){
            return  false;
        }
    }

    @Override
    public ProductUpdateDto getUpdatedProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        if (product == null){
            return null;
        }
        ProductUpdateDto productUpdateDto = modelMapper.map(product, ProductUpdateDto.class);
        return productUpdateDto;
    }

    @Override
    public boolean updateProduct(Long id, ProductUpdateDto productUpdateDto) {
        try {
            Product product = productRepository.findById(id).orElseThrow();
//            product.setName(productUpdateDto.getName());
            productRepository.save(product);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean removeProduct(Long id) {
        try {
            Product product = productRepository.findById(id).orElseThrow();
            productRepository.delete(product);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
