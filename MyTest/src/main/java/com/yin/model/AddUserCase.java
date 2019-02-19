package com.yin.model;

import lombok.Data;

@Data
public class AddUserCase {
    private String userName;
    private String password;
    private String sex;
    private int age;
    private int isDelete;
    private int permission;
    private String expected;
}
