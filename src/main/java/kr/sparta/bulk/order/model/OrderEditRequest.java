package kr.sparta.bulk.order.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderEditRequest {
    private Long id;
    private String product;
    private int quantity;
    private String customerName;
    private String customerAddress;
    private DeliveryStatus status;

    public Order toOrder() {
        return Order.builder()
                .id(id)
                .product(product)
                .quantity(quantity)
                .customerName(customerName)
                .customerAddress(customerAddress)
                .status(status)
                .build();
    }
}