package com.ykw.springboot.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author: sunxun
 * @date: 12/26/22 5:57 PM
 * @description:
 */

@Data
@Builder
@AllArgsConstructor
public class Article {

    private Long id;
    private String author;
}
