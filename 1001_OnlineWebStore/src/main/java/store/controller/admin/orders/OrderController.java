package store.controller.admin.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import store.service.resolver.ApiResolver;

@Controller
@RequestMapping("/admin/orders")
public class OrderController {

    @Autowired
    ApiResolver apiResolver;

    @GetMapping
    public String getAllOrder(Model model){
        model.addAttribute("orders", apiResolver.getAllOrders());
        return "admin_orders";
    }

    @PostMapping("/approve/{id}")
    public String approveOrder(@PathVariable Long id){
        System.out.println("approved " + id);
        return "redirect:/admin/orders";
    }

    @PostMapping("/edit/{id}")
    public String editAdminNotes(@PathVariable Long id){
        System.out.println("edited " + id);
        return "redirect:/admin/orders";
    }

    @PostMapping("/decline/{id}")
    public String declineOrder(@PathVariable Long id){
        System.out.println("declined " + id);
        return "redirect:/admin/orders";
    }
}
