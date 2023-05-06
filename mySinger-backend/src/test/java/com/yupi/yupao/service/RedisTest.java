package com.yupi.yupao.service;

import com.yupi.yupao.model.domain.User;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private RedissonClient redissonClient;

    @Test
    void test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        // 增
        valueOperations.set("yupiString", "dog");
        valueOperations.set("yupiInt", 1);
        valueOperations.set("yupiDouble", 2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("yupi");
        valueOperations.set("yupiUser", user);
        // 查
        Object yupi = valueOperations.get("yupiString");
        Assertions.assertTrue("dog".equals((String) yupi));
        yupi = valueOperations.get("yupiInt");
        Assertions.assertTrue(1 == (Integer) yupi);
        yupi = valueOperations.get("yupiDouble");
        Assertions.assertTrue(2.0 == (Double) yupi);
        System.out.println(valueOperations.get("yupiUser"));
        valueOperations.set("yupiString", "dog");
        redisTemplate.delete("yupiString");
    }

    @Test
    void  test2(){
        //list  数据存储在本地JVM内存种
        List<String> list = new ArrayList<>();
        list.add("lyc");
        System.out.println("list"+list.get(0));
        list.remove(0);
        //数据存储在redis内存中
        RList<String> rList = redissonClient.getList("test-list");
        rList.add("lyc");
        System.out.println("rList"+rList.get(0));
        rList.remove(0);
        //map中
        Map<String, InternalError> stringInternalErrorHashMap = new HashMap<>();


    }
}
