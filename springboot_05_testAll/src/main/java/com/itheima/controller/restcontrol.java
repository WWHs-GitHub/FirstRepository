package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import com.sun.corba.se.spi.activation.InvalidORBid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class restcontrol {

    @Autowired
    private IBookService iBookService;

    @GetMapping
    public R getAll(){
        //System.out.println(iBookService.getMap(null));
        return new R(true,iBookService.list(null));
    }

    @PostMapping
    public R save(@RequestBody Book book) throws Exception {
//        Book book=new Book();
//        book.setName("LOL");
//        book.setType("game");
//        book.setDescription("very good");
        if(book.getName().equals("123"))  throw new Exception();
        boolean flag = iBookService.save(book);
        return new R(flag,flag?"添加成功":"添加失败");
    }

    @PutMapping
    public R update(@RequestBody Book book) throws Exception{
//        Book book=new Book();
//        book.setId(27);
//        book.setName("LOL666");
//        book.setType("game");
//        book.setDescription("very good");
        if(book.getName().equals("456"))  throw new Exception();
        boolean flag = iBookService.updateById(book);
        return new R(flag,"",flag?"10000":"10001");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(iBookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getbyid(@PathVariable Integer id){
        return new R(true,iBookService.getById(id));
    }

//    @Autowired
//    private IpCountService ipCountService;

    @GetMapping("{current}/{size}")
    public R getpage(@PathVariable Integer current,@PathVariable Integer size,Book book){

//        ipCountService.count();

        IPage<Book> page = iBookService.getpage(current,size,book);

        if(current > page.getPages()){
            page = iBookService.getpage((int) page.getPages(), size,book);
        }

        return new R(true,page);
    }

}
