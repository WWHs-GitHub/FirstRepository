package com.itheima.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import com.itheima.service.Bookservice;
import com.itheima.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTestSimple {

    @Autowired
    private IBookService iBookService;

    @Test
    void save(){
        Book book=new Book();
        book.setName("王者荣耀");
        book.setType("Game");
        book.setDescription("打造最牛逼的游戏");
        System.out.println(iBookService.save(book));
    }

    @Test
    void update(){
        Book book=new Book();
        book.setName("王者荣耀666");
        book.setId(24);
        book.setType("Game");
        book.setDescription("打造最牛逼的游戏");
        System.out.println(iBookService.updateById(book));
    }

    @Test
    void deleteById(){
        System.out.println(iBookService.removeById(24));
    }

    @Test
    void selectById(){
        System.out.println(iBookService.getById(1));
    }

    @Test
    void selectAll(){
        System.out.println(iBookService.list());
    }

    @Test
    void selectpage(){
        IPage<Book> page=new Page<>(1,2);
        System.out.println(iBookService.page(page));
    }

    @Test
    void add(){
        Book book=new Book();
        book.setName("英雄联盟");
        book.setType("Game");
        book.setDescription("打造最牛逼的游戏");
        iBookService.add(book);
    }
}
