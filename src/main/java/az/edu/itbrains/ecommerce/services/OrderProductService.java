package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.models.Order;

public interface OrderProductService {
    boolean createOrderProduct(Order order);
}
