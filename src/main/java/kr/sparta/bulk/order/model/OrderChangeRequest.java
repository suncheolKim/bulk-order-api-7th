package kr.sparta.bulk.order.model;

import lombok.Getter;

@Getter
public class OrderChangeRequest {
    private Long id;
    private DeliveryStatus status;
}