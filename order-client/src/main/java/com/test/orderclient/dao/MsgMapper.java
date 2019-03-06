package com.test.orderclient.dao;

import com.test.orderclient.entity.Msg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MsgMapper {
    @Select("select * from t_msg")
    public List<Msg> findAll();
}
