package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 说明：用户信息业务层
 * @author：李尚兴
 * @date：2021-05-27 0:11
 * @version：1.0
 */
@Service
public class UserService {
    @Autowired
    @Qualifier("userMyBatisDAOImpl") // 根据名称注入实例
    private UserDAO userDAO;
    //@Autowired
    //private UserDAO userJpaDAOImpl;

    public void add() {
        System.out.println("UserService add()方法调用......");
        this.userDAO.add();
        //this.userJpaDAOImpl.add();
    }
}
