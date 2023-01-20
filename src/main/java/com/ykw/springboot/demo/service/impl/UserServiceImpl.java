package com.ykw.springboot.demo.service.impl;

import com.github.dozermapper.core.Mapper;
import com.ykw.springboot.demo.mapper.UserMapper;
import com.ykw.springboot.demo.model.User;
import com.ykw.springboot.demo.model.UserVO;
import com.ykw.springboot.demo.service.UserService;
import com.ykw.springboot.demo.utils.DozerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: sunxun
 * @date: 2023/1/18 19:54
 * @description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private Mapper dozerMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public void saveUser(UserVO user) {
        User userPO = dozerMapper.map(user, User.class);
        userMapper.insert(userPO);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public void updateUser(UserVO user) {
        User userPO = dozerMapper.map(user, User.class);
        userMapper.updateById(userPO);
    }

    @Override
    public UserVO getUserById(Integer id) {
        return dozerMapper.map(userMapper.selectById(id), UserVO.class);
    }

    @Override
    public List<UserVO> getAll() {
        List<User> userList = userMapper.selectList(null);
        return DozerUtils.mapList(userList, UserVO.class);
    }
}
