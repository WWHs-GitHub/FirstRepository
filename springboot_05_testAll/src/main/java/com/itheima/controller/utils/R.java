package com.itheima.controller.utils;

import com.itheima.domain.Book;
import lombok.Data;

import java.util.List;

@Data
public class R {
    private Boolean flag;
    private Object data;
    private String msg;
    private String index;

    public R(){}

    public R(Boolean flag){
        this.flag=flag;
    }

    public R(Boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }

    public R(Boolean flag,String msg){
        this.flag=flag;
        this.msg=msg;
    }

    public R(String msg){
        this.flag=false;
        this.msg=msg;
    }

    public R(Boolean flag,Object data,String index){
        this.flag=flag;
        this.data=data;
        this.index=index;
    }

//    public R(String index){
//        this.flag=false;
//        this.index=index;
//    }
}
