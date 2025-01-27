package com.dodannie.blog.realm;

import com.dodannie.blog.enums.ResultEnum;
import com.dodannie.blog.enums.StateEnums;
import com.dodannie.blog.exception.BlogException;
import com.dodannie.blog.pojo.Admin;
import com.dodannie.blog.pojo.User;
import com.dodannie.blog.service.AdminService;
import com.dodannie.blog.service.UserService;
import com.dodannie.blog.token.UsernamePasswordToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 处理管理员的登录和授权逻辑
 *
 * @Author: 杨德石
 * @Date: 2020/2/9 15:45
 * @Version 1.0
 */
public class AdminRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    /**
     * 授权方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return new SimpleAuthorizationInfo();
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        int state = usernamePasswordToken.getState();
//        if (state == StateEnums.ADMIN.getCode()) {
            Admin admin = adminService.getByUsername(username);
             if (admin == null) {
                // 用户不存在
                throw new BlogException(ResultEnum.ERROR.getCode(), "用户不存在！");
            }
            return new SimpleAuthenticationInfo(admin, admin.getPassword(), this.getName());
//        } else {
//            User user = userService.getByUsername(username);
//            if (user == null || user.getDeleted() == 1) {
//                throw new BlogException(ResultEnum.ERROR.getCode(), "用户不存在！");
//            }
//            return new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
//        }
    }
}
