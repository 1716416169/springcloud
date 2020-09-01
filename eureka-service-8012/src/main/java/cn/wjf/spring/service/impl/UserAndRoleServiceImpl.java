package cn.wjf.spring.service.impl;

import cn.wjf.spring.dao.UserAndRoleMapper;
import cn.wjf.spring.service.UserAndRoleService;
import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAndRoleServiceImpl implements UserAndRoleService {

    @Autowired
    UserAndRoleMapper userAndRoleMapper;

    public User selectUserById(int id, int first, int last) {
        User user = userAndRoleMapper.selectUserById(id, first, last);
        return user;
    }

    public Role selectRoleById(int id, int first, int last) {
        Role role = userAndRoleMapper.selectRoleById(id, first, last);
        return role;
    }

    public void insertUser(User user) {
        userAndRoleMapper.insertUser(user);
    }

    public void insertRole(Role role) {
        userAndRoleMapper.insertRole(role);
    }

    public void deleteUser(int id) {
        userAndRoleMapper.deleteUserById(id);
    }

    public void deleteRole(int id) {
        userAndRoleMapper.deleteRoleById(id);
    }

    public User updateUser(User user) {
        User user1 = userAndRoleMapper.updateUserById(user);
        return user1;
    }
}
