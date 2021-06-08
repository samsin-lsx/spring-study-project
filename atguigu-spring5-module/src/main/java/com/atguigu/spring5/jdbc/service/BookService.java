package com.atguigu.spring5.jdbc.service;

import com.atguigu.spring5.jdbc.bean.Book;
import com.atguigu.spring5.jdbc.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 说明：图书业务层
 * @author：李尚兴
 * @date：2021-05-30 10:55
 * @version：1.0
 */
@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;

    /**
     * 添加图书
     * @param book 图书对象
     * @return
     */
    public int addBook(Book book) {
        return this.bookDAO.addBook(book);
    }

    /**
     * 统计图书数量
     * @return
     */
    public int selectBookCount() {
        return this.bookDAO.selectBookCount();
    }

    /**
     * 根据序号查询图书
     * @param xh 序号
     * @return
     */
    public Book selectBookByXh(String xh) {
        return this.bookDAO.selectBookByXh(xh);
    }

    /**
     * 查询所有图书
     * @return
     */
    public List<Book> selectAllBook() {
        return this.bookDAO.selectAllBook();
    }

    /**
     * 批量添加
     * @param bookList
     */
    public void batchAddBook(List<Object[]> bookList) {
        this.bookDAO.batchAddBook(bookList);
    }

    /**
     * 批量修改
     * @param booksArray
     */
    public void batchUpdateBook(List<Object[]> booksArray) {
        this.bookDAO.batchUpdateBook(booksArray);
    }

    /**
     * 批量删除
     * @param booksArray
     */
    public void batchDeleteBook(List<Object[]> booksArray) {
        this.bookDAO.batchDeleteBook(booksArray);
    }
}
