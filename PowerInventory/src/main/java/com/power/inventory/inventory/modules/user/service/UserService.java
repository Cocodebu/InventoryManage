package com.power.inventory.inventory.modules.user.service;

import com.power.inventory.inventory.modules.user.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
public interface UserService {

    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);
    List<User> findAllUser();
}
