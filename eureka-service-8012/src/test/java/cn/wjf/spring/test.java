package cn.wjf.spring;

import cn.wjf.spring.service.impl.UserAndRoleServiceImpl;
import entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class test {


    @Autowired
    UserAndRoleServiceImpl userAndRoleService;
    @Test
    public void one(){
        User user = userAndRoleService.selectUserById(1, 0, 2);
        System.out.println(user);
        System.out.println("6666666");
    }
}
