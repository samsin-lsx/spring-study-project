package com.atguigu.spring5.jdbc.dao;

import com.atguigu.spring5.jdbc.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * 说明：图层数据层实现类
 * @author：李尚兴
 * @date：2021-05-30 10:56
 * @version：1.0
 */
@Repository
public class BookDAOImpl implements BookDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO t_book VALUES(?,?,?,?)";
        Object[] args = {book.getXh(), book.getBookName(), book.getPrice(), book.getPublishDate()};
        return this.jdbcTemplate.update(sql, args); // 增加、删除、修改都可以实现
    }

    @Override
    public Integer selectBookCount() {
        String sql = "SELECT COUNT(*) FROM t_book";
        return this.jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Book selectBookByXh(String xh) {
        String sql = "SELECT * FROM t_book WHERE xh = ?";
        return this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), xh);
    }

    @Override
    public List<Book> selectAllBook() {
        String sql = "SELECT * FROM t_book";
        return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public void batchAddBook(List<Object[]> bookList) {
        String sql = "INSERT INTO t_book VALUES(?,?,?,?)";
        int[] batchCount = this.jdbcTemplate.batchUpdate(sql, bookList);
        System.out.println(Arrays.toString(batchCount));
    }

    @Override
    public void batchUpdateBook(List<Object[]> booksArray) {
        String sql = "UPDATE t_book SET bookName=?, price=?, publishDate=? WHERE xh=?";
        int[] batchUpdateCount = this.jdbcTemplate.batchUpdate(sql, booksArray);
        System.out.println(Arrays.toString(batchUpdateCount));
    }

    @Override
    public void batchDeleteBook(List<Object[]> booksArray) {
        String sql = "DELETE FROM t_book WHERE xh=?";
        int[] batchDeleteCount = this.jdbcTemplate.batchUpdate(sql, booksArray);
        System.out.println(Arrays.toString(batchDeleteCount));
    }
}
