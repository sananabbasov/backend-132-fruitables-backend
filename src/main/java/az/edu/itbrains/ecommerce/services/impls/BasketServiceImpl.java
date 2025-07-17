package az.edu.itbrains.ecommerce.services.impls;

import az.edu.itbrains.ecommerce.dtos.basket.BasketAddDto;
import az.edu.itbrains.ecommerce.dtos.basket.BasketDto;
import az.edu.itbrains.ecommerce.models.Basket;
import az.edu.itbrains.ecommerce.models.Product;
import az.edu.itbrains.ecommerce.models.User;
import az.edu.itbrains.ecommerce.repositories.BasketRepository;
import az.edu.itbrains.ecommerce.services.BasketService;
import az.edu.itbrains.ecommerce.services.ProductService;
import az.edu.itbrains.ecommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;
    private final UserService userService;
    private final ProductService productService;
    private final ModelMapper modelMapper;


    @Override
    public List<BasketDto> getUserBaskets(String userEmail) {
        User user = userService.findUserByEmail(userEmail);
        List<Basket> basketList = user.getBaskets();
        List<BasketDto> basketDtoList = basketList.stream().map(product -> modelMapper.map(product, BasketDto.class)).collect(Collectors.toList());
        return basketDtoList;
    }

    @Override
    public void addToCart(BasketAddDto basketAddDto, String userEmail) {
        User user = userService.findUserByEmail(userEmail);
        Basket findBasket = basketRepository.findByUserIdAndProductId(user.getId(), basketAddDto.getProductId());
        if (findBasket != null){
            findBasket.setQuantity(findBasket.getQuantity()+ basketAddDto.getQuantity());
            basketRepository.save(findBasket);
        }else{
            Product product = productService.findProductById(basketAddDto.getProductId());
            Basket basket = new Basket();
            basket.setQuantity(basketAddDto.getQuantity());
            basket.setUser(user);
            basket.setProduct(product);
            basketRepository.save(basket);
        }
    }

    @Override
    public void removeBasketItem(Long id) {
        basketRepository.deleteById(id);
    }

    @Override
    public List<Basket> getUserBasket(String email) {
        return null;
    }
}
