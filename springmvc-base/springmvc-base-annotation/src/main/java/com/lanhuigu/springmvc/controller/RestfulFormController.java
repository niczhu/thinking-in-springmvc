package com.lanhuigu.springmvc.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lanhuigu.springmvc.entity.Address;
import com.lanhuigu.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping("/testRestful")
@Controller
public class RestfulTwoController {

    /**
     * 查询列表数据
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public String queryList(Map<String, Object> map) {
        List<User> lists = new ArrayList<User>();
        User user = new User();
        user.setUsername("ONE");
        user.setPassword("111111");
        Address address = new Address();
        address.setProvince("aaaaaa");
        address.setCity("bbbbbb");

        user.setAddress(address);
        lists.add(user);

        map.put("users", lists);
        return "list";
    }
    /**
     * 初始化编辑页面
     * @param map
     * @return
     */
    @RequestMapping(value="/input",method=RequestMethod.GET)
    public String editInput(Map<String, Object> map) {
        map.put("user", new User());
        return "input";
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value="/addUser",method=RequestMethod.POST)
    public String add(User user) {
        System.out.println(
                "username:"+user.getUsername() + "  " +
                        "password:"+user.getPassword() + "  " +
                        "gender:"+user.getGender() + "  " +
                        "province:"+user.getAddress().getProvince() + "  " +
                        "city:"+user.getAddress().getCity());
        return "redirect:/testRestful/list";
    }

}
