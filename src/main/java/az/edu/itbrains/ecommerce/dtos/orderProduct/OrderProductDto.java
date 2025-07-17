package az.edu.itbrains.ecommerce.dtos.orderProduct;

import az.edu.itbrains.ecommerce.dtos.product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductDto {
    private Float price;
    private int quantity;
    private ProductDto product;
}
