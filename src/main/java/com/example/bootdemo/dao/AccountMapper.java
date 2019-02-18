package com.example.bootdemo.dao;

import com.example.bootdemo.bean.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@CacheConfig(cacheNames = "account")
@Mapper
public interface AccountMapper {


    @Insert("insert into account(name , money) value (#{name} , #{money})")
    int add(@Param("name")String name , @Param("money")double money);


    @Update("update account set name = #{name},money = #{money} where id = #{id}")
    int update(@Param("name") String name, @Param("money") double money, @Param("id") int  id);

//    //删除缓存
//    @CacheEvict(key = "#id")
    @Delete("delete from account where id = #{id}")
    int delete(int id);

//    //查找替换缓存
//    @Cacheable(key = "#id" , sync = true)
    @Select("select id , name ,money from account where id = #{id}")
    Account findAccount(@Param("id") int id);

    //查询
    @Select("select id , name ,money from account")
    List<Account> findAccountList();

}
