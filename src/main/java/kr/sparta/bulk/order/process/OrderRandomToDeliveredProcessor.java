package kr.sparta.bulk.order.process;

import kr.sparta.bulk.order.model.Order;
import kr.sparta.bulk.order.model.OrderChangeDeliveryStatusRequest;
import kr.sparta.bulk.order.sample.SampleChangesToDelivered;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderRandomToDeliveredProcessor extends OrderBaseProcessor<Order> {
    public OrderRandomToDeliveredProcessor(List<Order> orderList) {
        super(orderList);
    }

    @Override
    protected long getMax() {
        return list.get(list.size()-1).getId();
    }

    @Override
    protected long getMin() {
        return list.get(0).getId();
    }

    @Override
    public List<Order> getResult() {
        final List<Order> newOrders = new ArrayList<>(list.size());

        final List<Integer> targets = getRandomTargets();
        final List<OrderChangeDeliveryStatusRequest> randomChageList = SampleChangesToDelivered.getRandomChageList(list, targets);

        for (Order order: list) {
            randomChageList.stream()
                    .filter(change -> Objects.equals(change.getId(), order.getId()))
                    .findFirst()
                    .ifPresent(change -> newOrders.add(change.toOrder(order)));
        }

        return newOrders;
    }
}
