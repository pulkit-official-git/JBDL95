package com.springcoreconecpts.ordersvc95;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderRequest {

    private String orderId;

    Map<String, String> orderDetails;
}
