package com.yin.service;

import com.yin.config.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我全部的Post方法")

public class MyPostMethod {
    private Cookie cookies;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功获取到cookie信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                            @RequestParam(value = "username",required = true) String username,
                            @RequestParam(value = "password",required = true) String password ){
        if(username.equals("zhangshan")&&password.equals("123456")){
            cookies = new Cookie("login","true");
            response.addCookie(cookies);
            return "恭喜你登录成功";
        }
        return "用户名或者密码错误";
    }

    @RequestMapping(value = "/userList",method = RequestMethod.POST)
    @ApiOperation(value = "这是获取用户列表",httpMethod = "POST")
    public String userList(HttpServletRequest request,
                         @RequestBody User u){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("login")&&
                cookie.getValue().equals("true")&&
                u.getUsername().equals("zhangshan")&&
                u.getPassword().equals("123456")){
                User user = new User();
                user.setName("lisi");
                user.setAge(18);
                user.setSex("man");
                return user.toString();
            }
        }
        return "参数不合法";
    }
}
