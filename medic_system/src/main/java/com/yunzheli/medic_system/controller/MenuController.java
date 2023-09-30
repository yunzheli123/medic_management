package com.yunzheli.medic_system.controller;


import com.alibaba.fastjson2.JSON;
import com.yunzheli.medic_system.bean.MainMenu;
import com.yunzheli.medic_system.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuDao menuDao;
    @RequestMapping("/menus")
    public String getAllMenus(){
        System.out.println("成功访问！！！");
        HashMap<String, Object> data = new HashMap<>();
        List<MainMenu> menus = menuDao.getMenus();
        if (menus!=null){
            data.put("menus",menus);
            data.put("flag",200);
        }else {
            data.put("flag",404);
        }
        String s = JSON.toJSONString(data);
        return s;
    }
}
