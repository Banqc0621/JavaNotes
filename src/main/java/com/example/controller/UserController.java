package com.example.controller;

import com.example.pojo.User;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: 班前程
 * @Company:北京万相信息
 * @Description:
 * @DateTime: 2023/8/1 15:53
 **/
@RequestMapping("users")
@RestController
public class UserController {


    /**
     * 通常建议当参数小于等于三个的时候进行这样直接参数传参比较方便。
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("add1")
    public String add1(String username, String password) {
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        return "sucess";
    }

    /**
     * 提交的参数名称需要和 类的属性保持一致
     * @param user
     * @return
     */
    @RequestMapping("add2")
    public String add2(User user) {
        System.out.println(user);
        return "sucess";
    }

    /**
     * 目前很主流:
     *
     * 接收RestFul风格：只关注数据的内容。
     * localhost:8080/users/add1/tom/123456
     *
     * 或者：
     * @RequestMapping("add3/{name}/{pass}")
     * public String add3(@PathVariable("name") String username, @PathVariable("pass") String password)
     *
     * @param
     * @return
     */
    @RequestMapping("add3/{username}/{password}")
    public String add3(@PathVariable String username, @PathVariable String password) {
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        return "sucess";
    }


    @RequestMapping("add4")
    public String add4(HttpServletRequest request) {
        //request对象中的数据是以key-value的键值对的形式存储的。
        //key就是前端的参数名称username=tom - (key就是username)

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        return "sucess";
    }

    @RequestMapping("add5")
    public User add5(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

    @RequestMapping("add6")
    public String add6(@RequestBody User user) {
        System.out.println(user);
        return "sucess";
    }

    @RequestMapping("add7")
    public String add7(@RequestBody User user) {
        System.out.println(user);
        return "sucess";
    }

    /**
     * {
     *     "username": "tom"
     *     "password": "123456"
     * }
     * @param map
     * @return
     */
    @RequestMapping("add8")
    public String add8(@RequestBody Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        System.out.println(username);
        System.out.println(password);
        return "sucess";
    }
}
