package com.dodannie.blog.service.impl;

import com.dodannie.blog.mapper.AdminMapper;
import com.dodannie.blog.pojo.Admin;
import com.dodannie.blog.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表服务实现类
 * </p>
 *
 * @author 稽哥
 * @date 2020-02-07 14:04:12
 * @Version 1.0
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    @Override
    public Admin getByUsername(String username) {
        return adminMapper.getByUsername(username);
    }

    @Override
    public Admin getAdmin() {
        return adminMapper.getAdmin();
    }

    @Override
    public void updateInfo(Admin admin) {
        adminMapper.update(admin);
    }

    @Override
    public void updatePassword(Admin admin) {
        Admin oldAdmin = adminMapper.getAdmin();
        oldAdmin.setPassword(admin.getPassword());
        adminMapper.update(oldAdmin);
    }
}
