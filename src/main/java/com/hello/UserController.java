package com.hello;

import com.dao.UserDao;
import com.github.pagehelper.PageHelper;
import com.po.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "分页测试")
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/users/{pageNo}")
    @ApiOperation(value = "查询用户")
    public List<User> getUsers(@PathVariable("pageNo") int pageNo) {
        PageHelper.startPage(pageNo, 10);
        List<User> users = userDao.getUsers();
        System.out.println(users);

        PageHelper.startPage(pageNo+1, 10);
        List<User> users2 = userDao.getUsers();
        users.addAll(users2);
        return users;
    }
}
