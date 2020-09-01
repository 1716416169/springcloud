package cn.wjf.spring.dao;

import entity.Role;
import entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserAndRoleMapper {

    public User selectUserById(@Param("id") int id, @Param("first") int first, @Param("last") int last);
    public Role selectRoleById(@Param("id") int id, @Param("first") int first, @Param("last") int last);

    public void insertUser(User user);
    public void insertRole(Role role);

    public void deleteUserById(@Param("id") int id);
    public void deleteRoleById(@Param("id")int id);

    public User updateUserById(User user);
    public Role updateRoleById(Role role);

}
