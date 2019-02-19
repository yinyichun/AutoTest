package com.yin.model;

import lombok.Data;

@Data
public class UpdateUserInfoCase {
    private int userid;
    private String userName;
    private String sex;
    private int age;
    private int isDelete;
    private int permission;
    private String expected;
}
