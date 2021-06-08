package com.atguigu.spring5.jdbc.dao;

import com.atguigu.spring5.jdbc.bean.Book;

import java.util.List;

/**
 * 说明：图书数据层
 * @author：李尚兴
 * @date：2021-05-30 10:55
 * @version：1.0
 */
public interface BookDAO {
    int addBook(Book book);

    Integer selectBookCount();

    Book selectBookByXh(String xh);

    List<Book> selectAllBook();

    void batchAddBook(List<Object[]> bookList);

    void batchUpdateBook(List<Object[]> booksArray);

    void batchDeleteBook(List<Object[]> booksArray);
}
