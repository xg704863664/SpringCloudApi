package com.test.orderclient.service;

import com.test.orderclient.dao.MsgMapper;
import com.test.orderclient.entity.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MsgService {
    @Autowired
    private MsgMapper msgMapper;
//    @Resource
//    private RocketMQTemplate rocketMQTemplate;

    public List<Msg> findAll(){
        return msgMapper.findAll();
    }

//    public void send(){
//        rocketMQTemplate.convertAndSend("test-topic-4", "Hello, World!");
//    }

}
