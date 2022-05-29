package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean add(Book book) {
        return bookDao.insert(book)>0;
    }

    @Override
    public IPage<Book> getpage(int current, int size) {
        IPage<Book> page=new Page<>(current,size);
        bookDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Book> getpage(int current, int size, Book book) {
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper();
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());

        IPage<Book> page=new Page<>(current,size);
        bookDao.selectPage(page,lqw);
        return page;
    }
}
