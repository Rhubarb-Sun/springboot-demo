package com.ykw.springboot.demo.model;

import lombok.Data;

/**
 * @author: sunxun
 * @date: 2023/1/18 19:41
 * @description: PO PO（Persistent Object）持久对象
 * 一个是阿里巴巴的开发手册中的定义中，DO（ Data Object）这个等同于上面的PO
 */

@Data
public class UserVO {

    private Integer id;

    private String  name;

    private String  password;

    private String  phone;
}
