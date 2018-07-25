package com.ujiuye.service;

import com.ujiuye.bean.User;

import java.util.List;

public interface UserService {
     void saveUser(User user);
     List<User> userList();
}
