package com.ykw.springboot.demo.service;

import com.ykw.springboot.demo.model.UserVO;

import java.util.List;

/**
 * @author: sunxun
 * @date: 2023/1/18 19:53
 * @description:
 */
public interface UserService {

    UserVO getUserById(Integer id);

    void saveUser(UserVO user);

    void deleteUser(Integer id);

    void updateUser(UserVO user);

    List<UserVO> getAll();
}
