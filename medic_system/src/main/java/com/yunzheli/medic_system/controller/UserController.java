package com.yunzheli.medic_system.controller;

import com.alibaba.fastjson2.JSON;
import com.yunzheli.medic_system.bean.QueryInfo;
import com.yunzheli.medic_system.bean.User;
import com.yunzheli.medic_system.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao udao;

    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo){
        //获取最大列表数和当前编号
        int numbers = udao.getUserCounts("%"+queryInfo.getQuery()+"%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

        List<User> users = udao.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<Object, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        String res_string= JSON.toJSONString(res);
        return res_string;
    }
    @RequestMapping("/userstate")
    public String updateUserState(@RequestParam("id")Integer id,
                                  @RequestParam("state")Boolean state){
        int i = udao.updateState(id,state);
        return i > 0 ? "success":"error";
    }
    @RequestMapping("addUser")
    public String addUser(@RequestBody User user){
        user.setRole("普通用户");
        user.setState(false);
        int i = udao.addUser(user);
        return i > 0?"success":"error";
    }
    @RequestMapping("deleteUser")
    public String deleteUser(int id){
        int i = udao.deleteUser(id);
        return i > 0 ? "success":"error";
    }
    @RequestMapping("/getupdate")
    public String getUpdateUser(int id){
        User user = udao.getUpdateUser(id);
        String string = JSON.toJSONString(user);
        return string;
    }
    @RequestMapping("/edituser")
    public String editUser(@RequestBody User user){
        int i = udao.editUser(user);
        return i>0?"success":"error";
    }
}
