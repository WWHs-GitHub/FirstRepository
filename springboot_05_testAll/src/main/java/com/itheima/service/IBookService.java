package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Book;

public interface IBookService extends IService<Book> {

    //新增功能
    Boolean add(Book book);

    IPage<Book> getpage(int current, int size);

    IPage<Book> getpage(int current, int size, Book book);
}
