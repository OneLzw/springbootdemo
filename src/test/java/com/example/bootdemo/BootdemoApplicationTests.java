package com.example.bootdemo;

import com.example.bootdemo.dao.AccountMapper;
import com.example.bootdemo.dao.RedisDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.provider.MD5;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootdemoApplicationTests {

    Logger logger = LoggerFactory.getLogger(BootdemoApplicationTests.class);

    @Autowired
    RedisDAO redisDAO;

    @Resource
    AccountMapper accountMapper;

    @Test
    public void contextLoads() {

    }

    @Test
    public void testRedis () {
        redisDAO.setKey("name" , "liming");
        redisDAO.setKey("age" , "20");
        logger.info(redisDAO.getValue("name"));
        logger.info(redisDAO.getValue("age"));
    }

    @Test
    public void testMysql () {
        int row = accountMapper.add("ddd", 4444);
        logger.info("add success : " + row);
    }

}
