package com.yin.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private String sex;
    private int age;
    private int isDelete;
    private int permission;

    @Override
    public String toString(){
        return ("{id:"+id+","+
                "userName:"+userName+","+
                "password:"+password+","+
                "sex:"+sex+","+
                "age:"+age+","+
                "isDelete:"+isDelete+","+
                "permission:"+permission+"}"
        );
    }
}
