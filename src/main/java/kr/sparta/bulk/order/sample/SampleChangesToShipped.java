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
public class SampleChangesToShipped {
    private static final RandomGenerator gen = RandomGenerator.of("L128X256MixRandom");

    public static List<OrderChangeDeliveryStatusRequest> getRandomChageList(List<Order> orderList, List<Integer> targets) {

        // 수정될 대상이 저장 될 리스트
        final List<OrderChangeDeliveryStatusRequest> changeOrders = new ArrayList<>(targets.size());

        for (Integer random: targets) {
            // 기존 주문
            final Order order = orderList.get(random);

            // 수정 DTO 생성
            final OrderChangeDeliveryStatusRequest editedOrder = OrderChangeDeliveryStatusRequest.builder()
                    .id(order.getId())
                    .status(DeliveryStatus.SHIPPED)
                    .build();

            changeOrders.add(editedOrder);
        }

        return changeOrders;
    }
}