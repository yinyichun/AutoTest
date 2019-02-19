package com.yin.service;

import com.sun.deploy.net.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我全部的GET方法")
public class MyGetMethod {

    @RequestMapping(value="/getCookies",method= RequestMethod.GET)
    @ApiOperation(value ="通过这个方法可以获取到Cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){

        //HttpServerLetRequest装请求信息的类
        //HttpSetverletResponse装响应信息的类
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);

        return "恭喜你获得Cookies成功";
    }

    /**
     * 要求客户端携带cookies访问
     * 这是一个需要携带cookies信息才能访问的get请求
     */
    @RequestMapping(value ="/get/WithCookies",method = RequestMethod.GET)
    @ApiOperation(value ="要求客户端带Cookies访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return "你必须携带一个cookies进行访问";
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "恭喜你采用cookies登录成功";
            }
        }
        return "你必须携带正确的cookies进行访问";
    }

    /*
   开发需要携带参数访问的GET方法
    第一种实现方式是采用URL：key=value&key=value
    我们来模拟获取商品列表
     */

    @RequestMapping(value = "/get/withParam",method = RequestMethod.GET)
    @ApiOperation(value ="通过key=value携带参数方法的实现",httpMethod = "GET")
    public Map<String,Integer> getWithParam(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("笔记本",4000);
        myList.put("干脆面",2);
        myList.put("手机",1000);
        return myList;
    }
     /*
   开发需要携带参数访问的GET方法
    第一种实现方式是采用URL：/param/param
    我们来模拟获取商品列表
     */
     @RequestMapping(value = "/get/withParam/{start}/{end}")
     @ApiOperation(value ="需要使用value/value带参数访问",httpMethod = "GET")
     public Map getWithParam1(@PathVariable Integer start, @PathVariable Integer end){
         Map<String,Integer> list = new HashMap<>();
         list.put("笔记本",4000);
         list.put("干脆面",2);
         list.put("手机",1000);
         return list;
     }
}
