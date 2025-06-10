package az.edu.itbrains.ecommerce.repositories;

import az.edu.itbrains.ecommerce.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
