package com.ykw.springboot.demo.service;

import com.ykw.springboot.demo.model.Article;

/**
 * @author: sunxun
 * @date: 12/27/22 11:18 AM
 * @description:
 */

public interface ArticleService {

    Article getArticleById(Long id);
}
