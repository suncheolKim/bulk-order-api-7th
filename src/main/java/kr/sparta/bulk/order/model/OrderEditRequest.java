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

    public Order toOrder() {
        return Order.builder()
                .id(id)
                .product(product)
                .quantity(quantity)
                .customerName(customerName)
                .customerAddress(customerAddress)
                .status(DeliveryStatus.PREPARE)
                .build();
    }
}