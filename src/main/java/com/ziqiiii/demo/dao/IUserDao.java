package com.ziqiiii.demo.dao;


import com.ziqiiii.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * create by ziqi.zhang on 2018/9/10
 */
@Repository
public interface IUserDao extends JpaRepository<User,Integer> {
    User findByName(String name);
}
