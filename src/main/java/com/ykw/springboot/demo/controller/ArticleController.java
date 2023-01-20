package com.ykw.springboot.demo.controller;

import com.ykw.springboot.demo.common.Response;
import com.ykw.springboot.demo.model.Article;
import com.ykw.springboot.demo.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author: sunxun
 * @date: 12/26/22 5:55 PM
 * @description:
 */

@RestController
@Slf4j
public class ArticleController {

//    @Resource
//    private ArticleService articleService;
//
//    @GetMapping("/articles/{id}")
//    public Response getArticleById(@PathVariable Long id) {
////        Article article = Article.builder().author("J. K. Rowling").id(id).build();
////
////        log.info("The response of getArticleById: \nArticle is: {}", article);
//        return Response.success(articleService.getArticleById(1L));
//    }
//
//    @PostMapping("/articles")
//    public Response saveArticle(@RequestBody Article article) {
//        log.info("The response of saveArticle: \nArticle is: {}", article);
//        return Response.success(article);
//    }
}
