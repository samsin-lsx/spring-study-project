package com.atguigu.spring5.transaction;

import com.atguigu.spring5.config.TransactionConfig;
import com.atguigu.spring5.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 说明：测试事务
 * @author：李尚兴
 * @date：2021-06-01 21:22
 * @version：1.0
 */
public class AccountTest {
    @Test
    public void testXMLAccountMoney() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-transaction.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney();
    }

    // 完全注解配置事务
    @Test
    public void testAnnotationAccountMoney() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney();
    }
}
