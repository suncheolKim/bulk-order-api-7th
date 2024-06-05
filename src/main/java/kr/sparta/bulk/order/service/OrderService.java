package kr.sparta.bulk.order.service;

import kr.sparta.bulk.order.model.Order;
import kr.sparta.bulk.order.model.OrderCreateRequest;
import kr.sparta.bulk.order.process.OrderRandomCreateProcessor;
import kr.sparta.bulk.order.process.OrderRandomEditProcessor;
import kr.sparta.bulk.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public int createAllOrders(List<OrderCreateRequest> newOrders) {
        OrderRandomCreateProcessor processor = new OrderRandomCreateProcessor(newOrders);
        final List<Order> orders = processor.getResult();
        orderRepository.saveAll(orders);

        return orders.size();
    }

    public int editOrders() {
        // 원래는 외부에서 수정 대상을 받아야 하지만 interface 강의와 관계없는 내용이라 내부에서 조회하는 것으로 한다.
        final List<Order> orderList = orderRepository.findAll();

        final OrderRandomEditProcessor processor = new OrderRandomEditProcessor(orderList);
        final List<Order> editedOrders = processor.getResult();

        orderRepository.saveAll(editedOrders);

        return editedOrders.size();
    }
}
