package store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import store.dtos.OrderDTO;
import store.service.resolver.ApiResolver;



@Controller
@RequestMapping("/")
public class StoreController {

    @Autowired
    ApiResolver apiResolver;

    @GetMapping(value = {"/", "/home"})
    public String getHomePage(Model model) {
        model.addAttribute("itemTypeDtos", apiResolver.getAllItemTypes());
        model.addAttribute("itemDtos", apiResolver.getFavoriteItems());
        return "client_home";
    }

    @GetMapping("/wares")
    public String getWarePage(@RequestParam("type") Integer id, Model model){
        model.addAttribute("itemTypeDtos", apiResolver.getAllItemTypes());
        model.addAttribute("itemDtos", apiResolver.getByItemTypeId(id));
        return "client_wares";
    }

    @GetMapping("/basket")
    public String showBasket(Model model){
        model.addAttribute("itemTypeDtos", apiResolver.getAllItemTypes());
        model.addAttribute("basket", apiResolver.getBasket());
        model.addAttribute("orderDTO", apiResolver.createNewOrder());
        return "client_basket";
    }

    @PostMapping("/basket/{orderId}")    //TODO make DeleteMapping request
    public String removeFromBasket(@RequestParam("itemId") Long itemId, @PathVariable Long orderId,  Model model, OrderDTO orderDTO){
        apiResolver.removeFromBasket(itemId);
        model.addAttribute("itemTypeDtos", apiResolver.getAllItemTypes());
        model.addAttribute("basket", apiResolver.getBasket());
        model.addAttribute("orderDTO", apiResolver.getOrder(orderId));
        return "client_basket";
    }

    @PostMapping("/basket/complete_order/{id}")
    public String getClientOrder(@PathVariable Long id, Model model, OrderDTO orderDTO){
        apiResolver.completeExistingOrder(id, orderDTO);
        model.addAttribute("order", apiResolver.getOrder(id));
        model.addAttribute("orderItems", apiResolver.getOrderItems(id));
        return "client_order";
    }

}
