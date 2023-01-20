package com.ykw.springboot.demo.controller;

import com.ykw.springboot.demo.common.Response;
import com.ykw.springboot.demo.mapper.UserMapper;
import com.ykw.springboot.demo.model.User;
import com.ykw.springboot.demo.model.UserVO;
import com.ykw.springboot.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author: sunxun
 * @date: 12/26/22 5:55 PM
 * @description:
 */

@RestController
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @GetMapping("/users/{id}")
    public Response getUserById(@PathVariable Integer id) {
//        Article article = Article.builder().author("J. K. Rowling").id(id).build();
//
//        log.info("The response of getArticleById: \nArticle is: {}", article);
        return Response.success(userService.getUserById(id));
    }

    @PostMapping("/users")
    public Response saveUser(@RequestBody User userVO) {
        log.info("Start to save a user! \n");
//        userService.saveUser(userVO);
        userMapper.insert(userVO);
        log.info("The response of saveUser: \n");
        return Response.success(userVO);
    }
}
