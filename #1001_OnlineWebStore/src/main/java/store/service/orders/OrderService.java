package store.service.orders;

import store.dtos.OrderDTO;
import store.entity.items.Item;
import store.entity.orders.Order;

import java.util.List;

public interface OrderService {

    void completeExistingOrder(Long id, OrderDTO orderDTO);

    Order createNewOrder();

    List<Order> getAllOrder();

    void addToBasket(Item item);

    void removeFromBasket(Long itemId);

    List<Item> getBasket();

    OrderDTO getOrder(Long id);

    List<Item> getOrderItems(Long id);
}
