package com.sparta.jpaquiz.repository;

import com.sparta.jpaquiz.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // TODO 3-1(페이징): 페이징 처리 시 Pageable, Page<T>을 사용하여 효율적으로 처리
    List<Order> findAll(); // 모든 데이터를 불러오는 비효율적인 메서드

}

