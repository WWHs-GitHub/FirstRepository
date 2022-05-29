package com.itheima.Dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05TestAllApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void selectAll() {
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void selectById(){
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void save(){
        Book book=new Book();
        book.setName("周易");
        book.setType("历史丛书");
        book.setDescription("一本好书");
        bookDao.insert(book);
    }

    @Test
    void update(){
        Book book=new Book();
        book.setId(23);
        book.setName("周易666");
        book.setType("历史丛书");
        book.setDescription("一本好书");
        bookDao.updateById(book);
    }

    @Test
    void deleteById(){
        bookDao.deleteById(23);
    }

    @Test
    void selectpage(){
        IPage<Book> page=new Page<>(1,2);
        bookDao.selectPage(page,null);
    }

    @Test
    void selectByCondition(){
         String name="周易";

        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper();
        lqw.like(name!=null,Book::getName,name);
        bookDao.selectList(lqw);
    }


}
