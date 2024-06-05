package kr.sparta.bulk.order.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderChangeDeliveryStatusRequest implements ProcessorMember {
    private Long id;
    private DeliveryStatus status;

    public Order toOrder(Order order) {
        return Order.builder()
                .id(order.getId())
                .product(order.getProduct())
                .quantity(order.getQuantity())
                .customerName(order.getCustomerName())
                .customerAddress(order.getCustomerAddress())
                .status(status)
                .build();
    }
}