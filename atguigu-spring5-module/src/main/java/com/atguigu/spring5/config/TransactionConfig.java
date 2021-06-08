package com.atguigu.spring5.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 说明：使用完全注解替代spring-transaction.xml文件实现事务操作配置类
 * @author：李尚兴
 * @date：2021-06-01 22:30
 * @version：1.0
 */
@Configuration // 配置类
@ComponentScan(basePackages = "com.atguigu.spring5") // 组件扫描
@EnableTransactionManagement // 开启事务
public class TransactionConfig {
    /**
     * 配置数据库连接池
     * @return
     */
    @Bean
    public DruidDataSource getDruidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/spring-project");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        return druidDataSource;
    }

    /**
     * 获取JdbcTemplate对象
     * @param dataSource 注入数据源，在IOC容器中根据类型找到DataSource对象进行注入
     * @return
     */
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    /**
     * 配置事务管理器对象
     * @param dataSource 注入数据源，在IOC容器中根据类型找到DataSource对象进行注入
     * @return
     */
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
