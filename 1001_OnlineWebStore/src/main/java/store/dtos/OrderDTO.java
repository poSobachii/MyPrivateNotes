package store.dtos;

import store.entity.orders.Order;

import java.sql.Date;
import java.text.DateFormat;
import java.util.List;

public class OrderDTO {
    private Long orderId;
    private String email;
    private String address;
    private String phone;
    private String userInfo;
    private String adminInfo;
    private String createdAt;
    private String orderStatus;
    private List<ItemDTO> orderedItems;

    public OrderDTO() {
    }


    public OrderDTO(Order order, List<ItemDTO> orderedItems) {
        this.orderId = order.getOrderId();
        this.address = order.getAddress();
        this.email = order.getEmail();
        this.phone = order.getPhone();
        this.userInfo = order.getUserInfo();
        this.createdAt = tranformDate(order.getOrderId());
        this.adminInfo = order.getAdminInfo();
        this.orderStatus = order.getOrderStatus().name();
        this.orderedItems = orderedItems;
    }

    private String tranformDate(Long millis) {
        return DateFormat.getDateTimeInstance().format(new Date(millis));
    }


    public Long getOrderId() {
        return orderId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(String adminInfo) {
        this.adminInfo = adminInfo;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<ItemDTO> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<ItemDTO> orderedItems) {
        this.orderedItems = orderedItems;
    }
}
