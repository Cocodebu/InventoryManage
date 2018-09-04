package com.power.inventory.inventory.modules.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 进入登陆页面
 */
@Controller
public class LoginController {

    @RequestMapping(value={"/login"})
    public String Login(Model model) {
        return "login";
    }

    @PostMapping(value={"/login"})
    public String LoginSubmit(Model model){
        return "redirect:/main";
    }


}
