package az.edu.itbrains.ecommerce.controllers.dashboard;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {


    @GetMapping("/dashboard")
    @PreAuthorize("hasAnyAuthority('admin')")
    public String dashboard(){
        return "dashboard/index.html";
    }
}
