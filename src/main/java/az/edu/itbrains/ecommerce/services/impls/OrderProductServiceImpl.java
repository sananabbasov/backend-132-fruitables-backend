package az.edu.itbrains.ecommerce.services.impls;

import az.edu.itbrains.ecommerce.dtos.basket.BasketDto;
import az.edu.itbrains.ecommerce.models.*;
import az.edu.itbrains.ecommerce.repositories.OrderProductRepository;
import az.edu.itbrains.ecommerce.services.BasketService;
import az.edu.itbrains.ecommerce.services.OrderProductService;
import az.edu.itbrains.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderProductServiceImpl implements OrderProductService {
    private final OrderProductRepository orderProductRepository;
    private final BasketService basketService;
    private final ProductService productService;

    @Override
    public boolean createOrderProduct(Order order) {
        User findUser = order.getUser();
        List<Basket> findBasket = findUser.getBaskets();

        for (Basket basket : findBasket) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setQuantity(basket.getQuantity());
            orderProduct.setPrice(basket.getProduct().getPrice());
            orderProduct.setProduct(basket.getProduct());
            productService.removeQuantityById(basket.getProduct().getId(), basket.getQuantity());
            orderProduct.setOrder(order);
            orderProductRepository.save(orderProduct);
        }

        return true;
    }
}
