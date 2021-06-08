package com.atguigu.spring5.springtest;

import com.atguigu.spring5.jdbc.bean.Book;
import com.atguigu.spring5.jdbc.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * 说明：Spring5整合Junit5版本
 * @author：李尚兴
 * @date：2021-06-03 22:00
 * @version：1.0
 */
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:spring-jdbc.xml")
@SpringJUnitConfig(locations = "classpath:spring-jdbc.xml") // 复合注解，使用此注解替代上面两个注解
public class SpringJunit5Test {
    @Autowired
    private BookService bookService;

    @Test
    public void testJUnit5() {
        List<Book> bookList = this.bookService.selectAllBook();
        System.out.println(bookList);
    }
}
