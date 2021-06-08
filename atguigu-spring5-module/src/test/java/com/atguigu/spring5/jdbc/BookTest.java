package com.atguigu.spring5.jdbc;

import com.atguigu.spring5.jdbc.bean.Book;
import com.atguigu.spring5.jdbc.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 说明：图书业务测试类
 * @author：李尚兴
 * @date：2021-05-30 11:12
 * @version：1.0
 */
public class BookTest {
    @Test
    public void testBatchDeleteBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> bookList = new ArrayList<>();
        for (int x = 8; x < 10; x++) {
            Object[] objects = {"100" + x};
            bookList.add(objects);
        }
        bookService.batchDeleteBook(bookList);
    }

    @Test
    public void testBatchUpdateBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> bookList = new ArrayList<>();
        for (int x = 4; x < 10; x++) {
            Object[] objects = {"降龙十" + x + "掌-郭靖", 100.0 * x, new Date(), "100" + x};
            bookList.add(objects);
        }
        bookService.batchUpdateBook(bookList);
    }

    @Test
    public void testBatchAddBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> bookList = new ArrayList<>();
        for (int x = 4; x < 10; x++) {
            Object[] objects = {"100" + x, "降龙十" + x + "掌", x, new Date()};
            bookList.add(objects);
        }
        bookService.batchAddBook(bookList);
    }

    @Test
    public void testSelectAllBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Book> bookList = bookService.selectAllBook();
        System.out.println(bookList);
    }

    @Test
    public void testSelectBookByXh() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = bookService.selectBookByXh("1001");
        System.out.println(book);
    }

    @Test
    public void testSelectBookCount() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        int bookCount = bookService.selectBookCount();
        System.out.println("成功查询" + bookCount + "条数据！");
    }

    @Test
    public void testAddBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setXh("1003");
        book.setBookName("独孤九剑");
        book.setPrice(2023348.99);
        book.setPublishDate(new Date());
        int addCount = bookService.addBook(book);
        System.out.println("成功插入" + addCount + "条数据！");
    }
}
