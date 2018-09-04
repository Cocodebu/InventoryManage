package com.power.inventory.inventory.modules.user.service;

import com.power.inventory.inventory.modules.user.dao.UserMapper;
import com.power.inventory.inventory.modules.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {

        List<User> users = new ArrayList<User>();

        return users;
    }

    @Override
    public List<User> findAllUser() {

        List<User> users = userMapper.findAll();
        return users;
    }
}
