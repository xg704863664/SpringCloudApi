package com.test.orderclient.entity;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Order {
    private Long id;
    private String orderNum;
}
