package kr.sparta.bulk.order.process;

import kr.sparta.bulk.order.model.Order;

import java.util.List;

public interface OrderRandomProcessable {
    List<Order> getResult();
}
