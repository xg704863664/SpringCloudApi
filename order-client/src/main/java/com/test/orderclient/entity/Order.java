package com.test.orderclient.entity;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Order implements Serializable {
    private Long id;
    private String orderNum;
}
