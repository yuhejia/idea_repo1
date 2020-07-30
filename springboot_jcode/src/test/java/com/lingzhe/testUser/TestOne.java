package com.lingzhe.testUser;

import com.lingzhe.SpringbootJcodeApplication;
import com.lingzhe.dao.repository.UserMapper;
import com.lingzhe.repository.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringbootJcodeApplication.class)
public class TestOne {

    //注入mapper
    @Autowired
    private UserMapper userMapper;

    //查询所有
    @Test
    public void findAllUser(){

        List<User> all = userMapper.findAll();
            System.out.println(all);


    }

}
