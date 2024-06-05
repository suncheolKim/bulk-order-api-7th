package kr.sparta.bulk.order.process;

import kr.sparta.bulk.order.model.Order;
import kr.sparta.bulk.order.model.OrderEditRequest;
import kr.sparta.bulk.order.sample.SampleEditOrders;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public class OrderRandomEditProcessor implements OrderRandomProcessable {
    private static final RandomGenerator gen = RandomGenerator.of("L128X256MixRandom");

    private final List<Order> orderList;

    public OrderRandomEditProcessor(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public List<Order> getResult() {
        final List<Order> newOrders = new ArrayList<>(orderList.size());

        // 랜덤으로 주문 수정
        final List<Integer> targets = getRandomTargets();
        final List<OrderEditRequest> editRequests = SampleEditOrders.getRandomEditList(orderList, targets);

        for (OrderEditRequest request : editRequests) {
            final Order newOrder = request.toOrder();
            newOrders.add(newOrder);
        }

        return newOrders;
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
