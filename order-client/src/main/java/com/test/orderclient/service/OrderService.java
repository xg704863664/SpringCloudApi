package com.test.orderclient.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.test.orderclient.dao.OrderMapper;
import com.test.orderclient.entity.Msg;
import com.test.orderclient.entity.Order;
import com.test.orderclient.entity.Test;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.MultiMatchQuery;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortMode;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private TestRepositry testRepositry;
    @Autowired
    public ElasticsearchTemplate elasticsearchTemplate;
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


    public Test findIn(){
//        SearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withQuery(QueryBuilders.termQuery("name","啊"))
//                .withFilter(QueryBuilders.rangeQuery("createDate").from("2019-05-08 15:00:00",true).to("2019-05-08 16:00:00",true))
//                .withFilter(QueryBuilders.existsQuery("cc"))
//                .withIndices("test6")
//                .withTypes("test6")
//                .withSort(SortBuilders.fieldSort("createDate").order(SortOrder.DESC))
//                .withFields("name")
//                .build();
//        List<Test> tests =   elasticsearchTemplate.queryForList(searchQuery,Test.class);
//       return orderMapper.findIn(1L,25L);
        Test test = new Test();
        test.setId(UUID.randomUUID().toString());
        test.setName("xg啊123");
        test.setName_1("xg啊123");
        test.setAge("123");
        test= testRepositry.save(test);
//        System.out.println(test.toString());
//        Iterable<Test> ll= testRepositry.findAll();
//        System.out.println(ll.toString());
//        List<Test> l=testRepositry.findByNameLike("*G*");
        System.out.println(test.toString());
        return new Test();
    }
}
