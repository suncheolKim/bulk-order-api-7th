package kr.sparta.bulk.order.process;

import kr.sparta.bulk.order.model.Order;
import kr.sparta.bulk.order.model.OrderEditRequest;
import kr.sparta.bulk.order.sample.SampleEditOrders;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public class OrderRandomEditProcessor extends OrderBaseProcessor<Order> {
    public OrderRandomEditProcessor(List<Order> orderList) {
        super(orderList);
    }

    @Override
    protected long getMax() {
        return list.get(list.size() - 1).getId();
    }

    @Override
    protected long getMin() {
        return list.get(0).getId();
    }

    @Override
    public List<Order> getResult() {
        final List<Order> newOrders = new ArrayList<>(list.size());

        // 랜덤으로 주문 수정
        final List<Integer> targets = getRandomTargets();
        final List<OrderEditRequest> editRequests = SampleEditOrders.getRandomEditList(list, targets);

        for (OrderEditRequest request : editRequests) {
            final Order newOrder = request.toOrder();
            newOrders.add(newOrder);
        }

        return newOrders;
    }
}
