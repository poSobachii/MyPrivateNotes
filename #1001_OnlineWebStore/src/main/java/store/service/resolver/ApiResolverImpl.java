package store.service.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import store.dtos.ItemDTO;
import store.dtos.ItemTypeDTO;
import store.dtos.OrderDTO;
import store.entity.items.Item;
import store.entity.items.ItemType;
import store.entity.orders.Order;
import store.service.items.ItemService;
import store.service.items.ItemTypeService;
import store.service.orders.OrderService;
import store.service.utility.OrderWaresEntityService;
import store.service.utility.PdfService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiResolverImpl implements ApiResolver {

    @Autowired
    ItemService itemService;
    @Autowired
    ItemTypeService itemTypeService;
    @Autowired
    OrderService orderService;
    @Autowired
    PdfService pdfService;
    @Autowired
    OrderWaresEntityService orderWaresEntityService;

    @Override
    public List<ItemDTO> getByItemTypeId(Integer itemTypeId) {
        List<Item> items = itemService.getByItemTypeId(itemTypeId);
        return items.stream().map(ItemDTO::new).collect(Collectors.toList());
    }

    @Override
    public ItemDTO getItemById(Long id) {
        return new ItemDTO(itemService.getById(id));
    }

    @Override
    public List<ItemTypeDTO> getAllItemTypes() {
        List<ItemType> itemTypes = itemTypeService.getAllItemTypes();
        return itemTypes.stream().map(ItemTypeDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<Item> getBasket() {
        return orderService.getBasket();
    }

    @Override
    public void removeFromBasket(Long itemId) {
        orderService.removeFromBasket(itemId);
    }

    @Override // todo make native query so other service will no be used
    public void addNewItem(Long id, ItemDTO itemDto) {
        ItemType type = itemTypeService.getById(id);
        Item item = new Item(itemDto.getName(), type, itemDto.getQuantity(), itemDto.getPrice(), itemDto.getDescription(), itemDto.isFavorite());
        itemService.save(item);
    }

    @Override // todo make native query so other service will no be used
    public Long updateItem(Long id, ItemDTO itemDTO) {
        Item item = itemService.getById(id);
        updateItem(item, itemDTO);
        itemService.save(item);
        return item.getItemType().getId();
    }



    @Override
    public Long deleteItemById(Long id) {
        return itemService.deleteById(id);
    }

    @Override
    public void addNewItemType(ItemType itemType) {
        itemTypeService.saveItemType(itemType);
    }

    @Override
    public ItemTypeDTO getItemTypeById(Long id) {
        ItemType itemType = itemTypeService.getById(id);
        return new ItemTypeDTO(itemType);
    }

    @Override
    public void updateItemType(Long id, ItemTypeDTO itemTypeChanges) {
        ItemType itemType = itemTypeService.getById(id);
        updateItemType(itemType, itemTypeChanges);
        itemTypeService.saveItemType(itemType);
    }

    @Override
    public void deleteItemTypeById(Long id) {
        itemTypeService.deleteById(id);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrder().stream().map(this::parseOrder).collect(Collectors.toList());
    }

    @Override
    public String addItemToBasket(Long itemId) {
        Item item = itemService.getById(itemId);
        orderService.addToBasket(item);
        String message = "Item " + item.getName() + " successfully added to basket";
        return message;
    }

    @Override
    public Resource getPdfOrder() {
        return pdfService.getPdf();
    }

    @Override
    public OrderDTO createNewOrder() {
        Order order = orderService.createNewOrder();
        return parseOrder(order);
    }

    @Override
    public void completeExistingOrder(Long id, OrderDTO orderDTO) {
        orderService.completeExistingOrder(id, orderDTO);
    }


    @Override
    public OrderDTO getOrder(Long id) {
        return orderService.getOrder(id);
    }

    @Override
    public List<Item> getOrderItems(Long id) {
        return orderService.getOrderItems(id);
    }

    @Override
    public List<ItemDTO> getFavoriteItems() {
        List<Item> items = itemService.getFavorites();
        return items.stream().map(ItemDTO::new).collect(Collectors.toList());
    }

    private OrderDTO parseOrder(Order order){
        List<ItemDTO> orderItems = orderWaresEntityService.transformItemsFromIds(order.getItemList()).stream().map(ItemDTO::new).collect(Collectors.toList());
        return new OrderDTO(order, orderItems);
    }

    private void updateItem(Item itemToUpdate, ItemDTO changes) {
        itemToUpdate.setName(changes.getName());
        itemToUpdate.setPrice(changes.getPrice());
        itemToUpdate.setQuantity(changes.getQuantity());
        itemToUpdate.setDescription(changes.getDescription());
        itemToUpdate.setFavorite(changes.isFavorite());
    }

    private void updateItemType(ItemType typeToUpdate, ItemTypeDTO changes){
        typeToUpdate.setTypeName(changes.getTypeName());
        typeToUpdate.setMaterial(changes.getMaterial());
        typeToUpdate.setDescription(changes.getDescription());
    }
}
