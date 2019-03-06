package com.test.orderclient.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.test.orderclient.dao.OrderMapper;
import com.test.orderclient.entity.Msg;
import com.test.orderclient.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private MsgService msgService;

    public Order findOne(){
        Order order = orderMapper.findOne(1L);
        if (order == null){
            return new Order();
        }
        return order;
    }

    public Long insert(){
        Order order = new Order();
        order.setOrderNum("ttt");
        Long id =orderMapper.insert(order);
        System.out.println(order.getId());
        return id;
    }

    public List<Order> findAll(){
        Page<Order> page = PageHelper.startPage(1,2);
        List<Order> orderList = orderMapper.findAll();
        Page<Msg> page1 = PageHelper.startPage(1,2);
        List<Msg> msgList = msgService.findAll();
        System.out.println(msgList.size());
        return orderList;
    }

    public List<Order> findIn(){
//       return orderMapper.findIn(1L,25L);
        return null;
    }
}
