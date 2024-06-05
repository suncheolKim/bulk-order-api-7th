package kr.sparta.bulk.order.process;

import kr.sparta.bulk.order.model.Order;
import kr.sparta.bulk.order.model.OrderCreateRequest;

import java.util.ArrayList;
import java.util.List;

public class OrderRandomCreateProcessor implements OrderRandomProcessable {
    private final List<OrderCreateRequest> orderCreateRequests;

    public OrderRandomCreateProcessor(List<OrderCreateRequest> orderCreateRequests) {
        this.orderCreateRequests = orderCreateRequests;
    }

    @Override
    public List<Order> getResult() {
        final List<Order> newOrders = new ArrayList<>(orderCreateRequests.size());

        for (OrderCreateRequest request : orderCreateRequests) {
            final Order newOrder = request.toOrder();
            newOrders.add(newOrder);
        }

        return newOrders;
    }
}
