package kr.sparta.bulk.order.sample;

import kr.sparta.bulk.order.model.DeliveryStatus;
import kr.sparta.bulk.order.model.Order;
import kr.sparta.bulk.order.model.OrderChangeDeliveryStatusRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SampleChangesToDelivered extends SampleChangesDeliveryStatus {
    public static List<OrderChangeDeliveryStatusRequest> getRandomChageList(List<Order> orderList, List<Integer> targets) {
        return getRandomChageList(orderList, targets, DeliveryStatus.DELIVERED);
    }
}