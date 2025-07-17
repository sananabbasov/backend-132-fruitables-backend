package az.edu.itbrains.ecommerce.services.impls;

import az.edu.itbrains.ecommerce.dtos.order.OrderDashboardDto;
import az.edu.itbrains.ecommerce.dtos.order.OrderUserDto;
import az.edu.itbrains.ecommerce.models.Order;
import az.edu.itbrains.ecommerce.models.User;
import az.edu.itbrains.ecommerce.repositories.OrderRepository;
import az.edu.itbrains.ecommerce.services.BasketService;
import az.edu.itbrains.ecommerce.services.OrderProductService;
import az.edu.itbrains.ecommerce.services.OrderService;
import az.edu.itbrains.ecommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductService orderProductService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    @Override
    public boolean orderProduct(String userEmail, OrderUserDto orderUserDto) {
        User user = userService.findUserByEmail(userEmail);
        Order order = new Order();
        order.setAddress(orderUserDto.getAddress());
        order.setCity(orderUserDto.getCity());
        order.setPostcode(orderUserDto.getPostcode());
        order.setPhoneNumber(orderUserDto.getPhoneNumber());
        order.setOrderDate(new Date());
        order.setUser(user);
        orderRepository.save(order);

        boolean result = orderProductService.createOrderProduct(order);
        return true;
    }

    @Override
    public List<OrderDashboardDto> getDashboardOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDashboardDto> orderDashboardDtoList = orders.stream().map(order -> modelMapper.map(order, OrderDashboardDto.class)).collect(Collectors.toList());
        return orderDashboardDtoList;
    }
}
