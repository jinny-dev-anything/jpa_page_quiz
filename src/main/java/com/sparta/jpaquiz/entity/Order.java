package com.sparta.jpaquiz.entity;

import com.sparta.jpaquiz.dto.OrderDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "P_ORDER")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;

    private LocalDateTime createdAt;

    private String status;

    // TODO 2(Entity 생성자 기본값 설정): @PrePersist를 사용해 createdAt, status 필드에 기본값을 설정합니다.
//    조건: createdAt은 현재시간(LocalDateTime.now()) 으로 설정
//    조건: status 는 "PENDING" 으로 설정
    public void prePersist() {
        ...
    }

    // TODO 5: Entity 가 Dto 에 의존하는 '의존성 역전 원칙 위반'을 수정
    public void setOrderNumberFromOrderDto(OrderDto orderDto) {
        this.orderNumber = orderDto.getOrderNumber();
    }
}

