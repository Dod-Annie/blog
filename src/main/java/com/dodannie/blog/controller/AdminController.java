package com.dodannie.blog.controller;

import com.dodannie.blog.enums.ResultEnum;
import com.dodannie.blog.enums.StateEnums;
import com.dodannie.blog.pojo.Admin;
import com.dodannie.blog.service.AdminService;
import com.dodannie.blog.token.UsernamePasswordToken;
import com.dodannie.blog.utils.Result;
import com.dodannie.blog.utils.ShiroUtils;
import com.dodannie.blog.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dod_Annie
 * @description
 * @date 2020/6/15 0:22
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Admin admin) {
        if (admin == null || StringUtils.isBlank(admin.getUsername()) || StringUtils.isBlank(admin.getPassword())) {
            return new Result<>(ResultEnum.PARAMS_NULL.getCode(), "用户名或密码错误！");
        }
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken authenticationToken = new UsernamePasswordToken(admin.getUsername(), admin.getPassword(), StateEnums.ADMIN.getCode());
        try {
            subject.login(authenticationToken);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(ResultEnum.PARAMS_NULL.getCode(), "用户名或密码错误！！");
        }
        Serializable sessionId = subject.getSession().getId();
        Map<String, Object> returnMap = new HashMap<>(2);
        returnMap.put("token", sessionId);
        return new Result<>(returnMap);
    }


    /**
     * 获取当前登录用户信息
     *
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Result<Admin> getLoginInfo() {
        Admin loginAdmin = (Admin) ShiroUtils.getLoginUser();
        loginAdmin.setPassword("");
        return new Result<>(loginAdmin);
    }

    /**
     * 查询管理员
     */
    @RequestMapping(value = "/getAdmin", method = RequestMethod.GET)
    public Result<Admin> getAdmin() {
        Admin admin = adminService.getAdmin();
        return new Result<>(admin);
    }

    /**
     * 更新个人信息
     * @param admin
     * @return
     */
    @RequestMapping(value = "/updateInfo", method = RequestMethod.PUT)
    public Result<Object> updateInfo(@RequestBody Admin admin) {
        adminService.updateInfo(admin);
        return new Result<>("更新成功！");
    }

    /**
     * 更新密码
     * @param admin
     * @return
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
    public Result<Object> updatePassword(@RequestBody Admin admin) {
        adminService.updatePassword(admin);
        return new Result<>("更新成功！");
    }

}
