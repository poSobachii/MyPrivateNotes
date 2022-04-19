package store.service.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.dtos.ItemDTO;
import store.dtos.OrderDTO;
import store.entity.items.Item;
import store.entity.orders.Order;
import store.repositories.OrderRepository;
import store.service.utility.OrderWaresEntityService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static store.enums.OrderStatus.CONFIRMED;
import static store.enums.OrderStatus.STARTED;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderWaresEntityService orderWaresEntityService;

    private List<Item> basket = new ArrayList<>();

    @Override
    public Order createNewOrder() {
        Long orderId = generateOrderId();
        List<Long> itemIds = orderWaresEntityService.transformItemIds(basket);
        Order order = new Order(orderId, itemIds, STARTED);
        orderRepository.save(order);
        return order;
    }

    @Override
    public void completeExistingOrder(Long id, OrderDTO orderDTO) {
        Order order = orderRepository.getOne(id);
        List<Long> itemIds = orderWaresEntityService.transformItemIds(basket);
        order.getItemList().clear();
        order.setItemList(itemIds);
        order.setEmail(orderDTO.getEmail());
        order.setAddress(orderDTO.getAddress());
        order.setPhone(orderDTO.getPhone());
        order.setUserInfo(orderDTO.getUserInfo());
        order.setAdminInfo("");
        order.setOrderStatus(CONFIRMED);
        orderRepository.save(order);
        basket.clear();
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void addToBasket(Item item) {
        basket.add(item);
    }

    @Override
    public void removeFromBasket(Long itemId) {
        basket.removeIf(item -> item.getId().equals(itemId));
    }

    @Override
    public List<Item> getBasket() {
        return basket;
    }

    @Override
    public OrderDTO getOrder(Long id) {
        Order order = orderRepository.getOne(id);
        List<ItemDTO> orderItems = orderWaresEntityService.transformItemsFromIds(order.getItemList()).stream().map(ItemDTO::new).collect(Collectors.toList());
        return new OrderDTO(order, orderItems);
    }

    @Override
    public List<Item> getOrderItems(Long id) {
        Order order = orderRepository.getOne(id);
        return orderWaresEntityService.transformItemsFromIds(order.getItemList());
    }

    private Long generateOrderId() {
        return System.currentTimeMillis();
    }
}
