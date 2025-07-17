package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.dtos.basket.BasketAddDto;
import az.edu.itbrains.ecommerce.dtos.basket.BasketDto;
import az.edu.itbrains.ecommerce.models.Basket;

import java.util.List;

public interface BasketService {
    List<BasketDto> getUserBaskets(String userEmail);

    void addToCart(BasketAddDto basketAddDto, String userEmail);

    void removeBasketItem(Long id);

    List<Basket> getUserBasket(String email);
}
