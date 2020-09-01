package cn.wjf.spring.service;

import entity.Role;
import entity.User;

public interface UserAndRoleService {
    public User selectUserById(int id, int first, int last);
    public Role selectRoleById(int id,int first,int last);

    public void insertUser(User user);
    public void insertRole(Role role);

    public void deleteUser(int id);
    public void deleteRole(int id);

    public User updateUser(User user);


}
