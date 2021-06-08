package com.atguigu.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 说明：账户数据层实现类
 * @author：李尚兴
 * @date：2021-06-01 21:13
 * @version：1.0
 */
@Repository
public class AccountDAOImpl implements AccountDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void reduceMoney() {
        String sql = "UPDATE tbl_user SET money = money - ? WHERE last_name = ?";
        int updateCount = this.jdbcTemplate.update(sql, 100, "zhangsan");
        System.out.println("【zhangsan转账成功】转账100元，更新" + updateCount + "条数据！");
    }

    @Override
    public void addMoney() {
        String sql = "UPDATE tbl_user SET money = money + ? WHERE last_name = ?";
        int updateCount = this.jdbcTemplate.update(sql, 100, "lisi");
        System.out.println("【lisi转账成功】收到100元，更新" + updateCount + "条数据！");
    }
}
