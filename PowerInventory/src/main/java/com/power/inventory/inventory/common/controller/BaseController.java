package com.power.inventory.inventory.common.controller;

import com.power.inventory.inventory.modules.user.model.User;
import com.power.inventory.inventory.modules.user.model.XUser;
import com.power.inventory.inventory.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;




@Controller
public class BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/main"})
    public String MainPage(Model model){
        return "main";
    }

    @RequestMapping(value={"/base_data/user"})
    public String BaseDataPage(Model model){
//        List<XUser> users = new ArrayList<XUser>();
//        XUser user1 = new XUser();
//        user1.setId("1");
//        user1.setUserName("name1");
//
//        XUser user2 = new XUser();
//        user2.setId("2");
//        user2.setUserName("name2");
//
//        users.add(user1);
//        users.add(user2);
        List<User> users = userService.findAllUser();
        List<XUser> xusers = new ArrayList<XUser>();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            XUser xuser = new XUser();
            xuser.setId(user.getId().toString());
            xuser.setUserName(user.getUsername());
            xusers.add(xuser);
        }
        model.addAttribute("users", xusers);

        return "userManager";
    }
}
