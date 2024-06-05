package kr.sparta.bulk.order.controller;

import kr.sparta.bulk.order.model.OrderCreateRequest;
import kr.sparta.bulk.order.sample.SampleNewOrders;
import kr.sparta.bulk.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/sample/bulk-create")
    public int createAllOrders() {
        /* 생성 대상은 사실상 외부에서 List로 넘어와야 함. 하지만 빠른 진행을 위해 내부에서 샘플 데이터를 생성 */
        final List<OrderCreateRequest> orderCreateRequests = SampleNewOrders.get();

        return orderService.createAllOrders(orderCreateRequests);
    }

    @PutMapping("/sample/bulk-edit")
    public int updateAllOrders() {
        return orderService.editOrders(/* 수정 대상은 사실상 외부에서 넘어와야 함 */);
    }
}
