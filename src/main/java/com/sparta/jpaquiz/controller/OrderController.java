package com.sparta.jpaquiz.controller;

import com.sparta.jpaquiz.dto.OrderDto;
import com.sparta.jpaquiz.entity.Order;
import com.sparta.jpaquiz.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 주문 생성
    @PostMapping
    public String createOrder(@RequestBody OrderDto orderDto) {
        orderService.createOrder(orderDto);
        return "Order created successfully!";
    }

    // 주문 상태 업데이트
    @PutMapping("/{id}/status")
    public String updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
        orderService.updateOrderStatus(id, status);
        return "Order status updated!";
    }

    // 페이징을 통한 주문 조회
    @GetMapping
    // TODO 4(페이징): @PageableDefault를 사용해 페이지 사이즈 및 정렬 기준 기본값 설정
//    조건: size = 10, sort = "id", direction = Sort.Direction.ASC
    public Page<Order> getAllOrders(Pageable pageable) {
        return orderService.getAllOrders(pageable);
    }
}

