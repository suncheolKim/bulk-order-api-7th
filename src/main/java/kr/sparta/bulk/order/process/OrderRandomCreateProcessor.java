package kr.sparta.bulk.order.process;

import kr.sparta.bulk.order.model.Order;
import kr.sparta.bulk.order.model.OrderCreateRequest;

import java.util.ArrayList;
import java.util.List;

public class OrderRandomCreateProcessor extends OrderBaseProcessor<OrderCreateRequest> {
    public OrderRandomCreateProcessor(List<OrderCreateRequest> orderCreateRequests) {
        super(orderCreateRequests);
    }

    @Override
    protected long getMax() {
        return list.size();
    }

    @Override
    protected long getMin() {
        return 0L;
    }

    @Override
    public List<Order> getResult() {
        final List<Order> newOrders = new ArrayList<>(list.size());

        for (OrderCreateRequest request : list) {
            final Order newOrder = request.toOrder();
            newOrders.add(newOrder);
        }

        return newOrders;
    }
}
