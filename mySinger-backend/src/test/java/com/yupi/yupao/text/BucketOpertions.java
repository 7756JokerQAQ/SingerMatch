package com.yupi.yupao.text;


import com.yupi.yupao.model.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@SpringBootTest
public class BucketOpertions {
    @Autowired
    RedissonClient redissonClient;

    public void bucketOper(){
        RBucket<User> anyObjectRBucket = redissonClient.getBucket("LYCBuckets");

    }

}
