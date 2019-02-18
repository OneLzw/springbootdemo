package com.example.bootdemo.service;

import com.example.bootdemo.bean.Account;
import com.example.bootdemo.dao.AccountMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@CacheConfig(cacheNames = "account")
@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    public int add(String name, double money) {
        return accountMapper.add(name, money);
    }

    @CacheEvict(key = "#id")
    public int update(String name, double money, int id) {
        return accountMapper.update(name, money, id);
    }

    @CacheEvict(key = "#id")
    public int delete(int id) {
        return accountMapper.delete(id);
    }

    @Cacheable(key = "#id" , sync = true)
    public Account findAccount(int id) {
        return accountMapper.findAccount(id);
    }

    public List<Account> findAccountList() {
        return accountMapper.findAccountList();
    }
}
