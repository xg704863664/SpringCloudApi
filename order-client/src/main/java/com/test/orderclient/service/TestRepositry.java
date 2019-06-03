package com.test.orderclient.service;

import com.test.orderclient.entity.Test;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestRepositry extends CrudRepository<Test,String> {
    List<Test> findByNameLike(String name);
}
