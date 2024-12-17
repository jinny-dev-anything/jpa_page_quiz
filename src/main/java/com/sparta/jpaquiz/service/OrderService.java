package com.sparta.jpaquiz.service;

import com.sparta.jpaquiz.dto.OrderDto;
import com.sparta.jpaquiz.entity.Order;
import com.sparta.jpaquiz.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderNumberFromOrderDto(orderDto);
        return orderRepository.save(order);
    }

    // TODO 6: save()를 호출하지 말고, 더티 체킹에 의해 변경 사항이 자동 반영되도록 설정
    // HINT:  @Transactional
    // 비고:  더티체킹을 활용하면 코드가 간결해지고, 불필요한 I/O를 최고화하며, 트랜잭션 범위에서 일관된 동작 보장
    public void updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        order.setStatus(status);
        orderRepository.save(order); // 이부분을 삭제 할 것!
    }

    // TODO 3-2(페이징): 페이징 처리에 @PageableDefault를 사용하여 기본값 적용
    public Page<Order> getAllOrders(Pageable pageable) {
        return (Page<Order>) orderRepository.findAll(); // 모든 데이터를 불러오는 비효율적인 메서드
    }
}

