package az.edu.itbrains.ecommerce.controllers.dashboard;

import az.edu.itbrains.ecommerce.dtos.order.OrderDashboardDto;
import az.edu.itbrains.ecommerce.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @GetMapping("/dashboard/orders")
    @PreAuthorize("isAuthenticated()")
    public String orders(Model model){

        List<OrderDashboardDto> orderDashboardDtoList = orderService.getDashboardOrders();
        model.addAttribute("orders",orderDashboardDtoList);

        return "dashboard/order/index.html";
    }
}
