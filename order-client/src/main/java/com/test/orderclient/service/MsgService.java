package com.test.orderclient.service;

import com.test.orderclient.dao.MsgMapper;
import com.test.orderclient.entity.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgService {
    @Autowired
    private MsgMapper msgMapper;

    public List<Msg> findAll(){
        return msgMapper.findAll();
    }
}
