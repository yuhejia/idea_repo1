package com.lingzhe.testUser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingzhe.SpringbootJcodeApplication;
import com.lingzhe.dao.repository.UserMapper;
import com.lingzhe.repository.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringbootJcodeApplication.class)
public class RedisTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String,String > redisTemplate;

    //需求先从redis中查找数据 没有就去数据库，找完保存到redis中
    @Test
    public void testOne() throws JsonProcessingException {
        //先从redis中获取json格式的数据
        String userListJson = redisTemplate.boundValueOps("user.findAll").get();
        System.out.println(userListJson);
        if(userListJson == null){
            //从数据库中获取
            List<User> userList = userMapper.findAll();
            //把数据保存到redis  先转换为json的数据
            ObjectMapper objectMapper = new ObjectMapper();
            userListJson = objectMapper.writeValueAsString(userList);
            //存储到redis中
            redisTemplate.boundValueOps("user.findAll").set(userListJson);
        }else{
            System.out.println("从redis中获得数据"+userMapper);
        }
    }
}
