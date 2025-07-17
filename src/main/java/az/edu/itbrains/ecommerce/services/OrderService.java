package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.dtos.order.OrderDashboardDto;
import az.edu.itbrains.ecommerce.dtos.order.OrderUserDto;

import java.util.List;

public interface OrderService {
    boolean orderProduct(String userEmail, OrderUserDto orderUserDto);

    List<OrderDashboardDto> getDashboardOrders();
}
