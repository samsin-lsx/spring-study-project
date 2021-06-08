package com.atguigu.spring5.bean;

/**
 * 说明：账户实体类
 * @author：李尚兴
 * @date：2021-06-01 21:11
 * @version：1.0
 */
public class Account {
    private Integer id;
    private String lastName;
    private Integer money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", money=" + money +
                '}';
    }
}
