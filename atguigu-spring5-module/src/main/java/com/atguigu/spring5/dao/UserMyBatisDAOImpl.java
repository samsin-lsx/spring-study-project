package com.atguigu.spring5.dao;

import org.springframework.stereotype.Repository;

/**
 * 说明：使用MyBatis实现用户接口操作
 * @author：李尚兴
 * @date：2021-05-28 0:47
 * @version：1.0
 */
@Repository("userMyBatisDAOImpl")
public class UserMyBatisDAOImpl implements UserDAO {
    @Override
    public void add() {
        System.out.println("【UserDAO实现】使用MyBatis方式实现......");
    }
}
