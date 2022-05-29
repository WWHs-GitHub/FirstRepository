package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface Bookservice {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book selectById(Integer id);
    List<Book> selectAll();

    IPage<Book> selectPage(int current,int size);
}
