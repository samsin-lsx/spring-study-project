package com.atguigu.spring5.springtest;

import com.atguigu.spring5.jdbc.bean.Book;
import com.atguigu.spring5.jdbc.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 说明：Spring5整合JUnit4
 * @author：李尚兴
 * @date：2021-06-03 21:43
 * @version：1.0
 */
@RunWith(SpringJUnit4ClassRunner.class) // 单元测试框架
@ContextConfiguration("classpath:spring-jdbc.xml") // 加载配置文件
public class SpringJunit4Test {
    @Autowired
    private BookService bookService;

    @Test
    public void testJUnit4() {
        System.out.println(this.bookService);
        List<Book> allBooks = this.bookService.selectAllBook();
        System.out.println(allBooks);
    }
}
