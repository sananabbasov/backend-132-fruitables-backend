package az.edu.itbrains.ecommerce.dtos.basket;

import az.edu.itbrains.ecommerce.dtos.product.ProductDto;
import az.edu.itbrains.ecommerce.dtos.user.UserDto;

public class BasketUserDto {
    private Long id;
    private int quantity;
    private Float price;
    private Float totalPrice;
    private ProductDto product;
}
