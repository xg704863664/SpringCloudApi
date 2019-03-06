package com.test.orderclient.dao;

import com.test.orderclient.entity.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    @Select("select * from `order` as o where o.`id` = #{id}")
    Order findOne(Long id);

    @Insert("insert into `order`(`order_num`) values(#{orderNum})")
    @Options(useGeneratedKeys = true)
//    @SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty = "id",resultType = Long.class,before = false)
    Long insert(Order order);

    @Select("select * from `order`")
    List<Order> findAll();

//    @Select("select * from `order` as o where o.`id` in #{ids}")
//    List<Order> findIn(@Param("ids")Long... ids);
}
