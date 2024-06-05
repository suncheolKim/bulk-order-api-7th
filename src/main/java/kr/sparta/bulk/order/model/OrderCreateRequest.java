package kr.sparta.bulk.order.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderCreateRequest implements ProcessorMember {
    private String product;
    private int quantity;
    private String customerName;
    private String customerAddress;

    public Order toOrder() {
        return Order.builder()
                .product(product)
                .quantity(quantity)
                .customerName(customerName)
                .customerAddress(customerAddress)
                .status(DeliveryStatus.PREPARE)
                .build();
    }
}