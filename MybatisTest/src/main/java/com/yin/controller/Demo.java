package com.yin.controller;

import com.yin.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(value = "v1",description = "这是我的第一个mybatis的demo")
@RequestMapping(value = "v1")
public class Demo {
    //首先获得一个执行SQL语句的对象
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户的个数",httpMethod = "GET")
    public int getUserCount(){
       return template.selectOne("getUserCount");

    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "可以通过此请求添加用户信息",httpMethod = "POSY")
    public int addUser(@RequestBody User user){
       return template.insert("addUser",user);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "可以通过此请求更新用户信息",httpMethod = "POSY")
    public int updateUser(@RequestBody User user){
        return template.update("updateUser",user);
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    @ApiOperation(value = "可以通过此请求更新用户信息",httpMethod = "GET")
    public int deleteUser(@RequestParam int id){
        return template.delete("deleteUser",id);
    }
}
