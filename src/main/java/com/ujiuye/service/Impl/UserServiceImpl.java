package com.ujiuye.service.Impl;

import com.ujiuye.bean.User;
import com.ujiuye.dao.UserMapper;
import com.ujiuye.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper mapper;
    @Override
    public void saveUser(User user) {
        mapper.saveUser(user);
    }

    @Override
    public List<User> userList() {
        List<User> list = mapper.userList();
        return list;
    }

}
