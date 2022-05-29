package com.itheima.Service;


import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.Bookservice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private Bookservice bookservice;

    @Test
    void save(){
        Book book=new Book();
        book.setName("王者荣耀");
        book.setType("Game");
        book.setDescription("打造最牛逼的游戏");
        System.out.println(bookservice.save(book));
    }

    @Test
    void update(){
        Book book=new Book();
        book.setName("王者荣耀666");
        book.setId(24);
        book.setType("Game");
        book.setDescription("打造最牛逼的游戏");
        System.out.println(bookservice.update(book));
    }

    @Test
    void deleteById(){
        System.out.println(bookservice.delete(24));
    }

    @Test
    void selectById(){
        System.out.println(bookservice.selectById(1));
    }

    @Test
    void selectAll(){
        System.out.println(bookservice.selectAll());
    }

    @Test
    void selectpage(){
        System.out.println(bookservice.selectPage(1,2));
    }
}
