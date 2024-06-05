package kr.sparta.bulk.order.dto;

import kr.sparta.bulk.order.model.DeliveryStatus;
import kr.sparta.bulk.order.model.Order;
import lombok.Getter;

@Getter
public class OrderDto {
    private final Long id;
    private final String product;
    private final int quantity;
    private final String customerName;
    private final String customerAddress;
    private final DeliveryStatus status;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.product = order.getProduct();
        this.quantity = order.getQuantity();
        this.customerName = order.getCustomerName();
        this.customerAddress = order.getCustomerAddress();
        this.status = order.getStatus();
    }
}
