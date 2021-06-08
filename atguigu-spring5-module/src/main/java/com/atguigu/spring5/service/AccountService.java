package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.AccountDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 说明：转账业务
 * @author：李尚兴
 * @date：2021-06-01 21:18
 * @version：1.0
 */
@Service
public class AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountDAO accountDAO;

    /**
     * 转账方法
     */
    //@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ) // 传播行为、隔离级别都是默认配置【使用XML配置时需要注释掉】
    @Transactional // 使用完全注解开发时需要加上
    public void accountMoney() {
        LOGGER.info("张三开始转账了");
        this.accountDAO.reduceMoney(); // zhangsan转账100
        LOGGER.warn("张三已经转出100");
        System.out.println(10 / 0);
        this.accountDAO.addMoney();    // lisi收账100
    }
}
