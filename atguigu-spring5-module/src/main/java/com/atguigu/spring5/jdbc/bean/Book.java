package com.atguigu.spring5.jdbc.bean;

import java.util.Date;

/**
 * 说明：图书实体类
 *
 * @author：李尚兴
 * @date：2021-05-30 11:04
 * @version：1.0
 */
public class Book {
    private String xh;
    private String bookName;
    private Double price;
    private Date publishDate;

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "xh='" + xh + '\'' +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                '}';
    }
}
