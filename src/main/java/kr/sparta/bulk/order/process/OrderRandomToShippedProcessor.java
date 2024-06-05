package kr.sparta.bulk.order.process;

import kr.sparta.bulk.order.model.Order;
import kr.sparta.bulk.order.model.OrderChangeDeliveryStatusRequest;
import kr.sparta.bulk.order.sample.SampleChangesToShipped;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public class OrderRandomToShippedProcessor implements OrderRandomProcessable{
    private static final RandomGenerator gen = RandomGenerator.of("L128X256MixRandom");
    private final List<Order> orderList;

    public OrderRandomToShippedProcessor(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public List<Order> getResult() {
        final List<Order> toShippedTargets = new ArrayList<>(orderList.size());

        final List<Integer> randomTargets = getRandomTargets();
        final List<OrderChangeDeliveryStatusRequest> randomChageList = SampleChangesToShipped.getRandomChageList(orderList, randomTargets);

        for (Order order: orderList) {
            randomChageList.stream()
                    .filter(change -> Objects.equals(change.getId(), order.getId()))
                    .findFirst()
                    .ifPresent(change -> toShippedTargets.add(change.toOrder(order)));
        }

        return toShippedTargets;
    }

    private List<Integer> getRandomTargets() {
        // 랜덤으로 수정할 대상의 개수 선정
        final int limit = gen.nextInt(orderList.size());

        final int min = Math.toIntExact(orderList.get(0).getId());
        final int max = Math.toIntExact(orderList.get(orderList.size() - 1).getId());

        final IntStream randoms = gen.ints(min, max)
                .limit(limit);

        return randoms.boxed().toList();
    }
}
