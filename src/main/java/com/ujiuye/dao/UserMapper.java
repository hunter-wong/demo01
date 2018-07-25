package com.ujiuye.dao;

import com.ujiuye.bean.User;

import java.util.List;

public interface UserMapper {
    public void saveUser(User user);

    public List<User> userList();



}
