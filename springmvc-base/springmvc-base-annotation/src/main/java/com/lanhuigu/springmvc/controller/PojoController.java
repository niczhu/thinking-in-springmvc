package com.lanhuigu.springmvc.controller;

import com.lanhuigu.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yihonglei
 */
@Controller
@RequestMapping("/testpj")
public class PojoController {
    private static final String SUCCESS = "success";

    @RequestMapping(value="/testPojo")
    public String testPojo(User user) {
        System.out.println("testPojo--username:" + user.getUsername() +
                ",password=" + user.getPassword() +
                ",province=" + user.getAddress().getProvince() +
                ",city=" + user.getAddress().getCity());
        return SUCCESS;
    }
}
