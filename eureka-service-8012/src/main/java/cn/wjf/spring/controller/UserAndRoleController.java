package cn.wjf.spring.controller;
import cn.wjf.spring.service.impl.UserAndRoleServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAndRoleController {
    @Autowired
    UserAndRoleServiceImpl userAndRoleService;

    @HystrixCommand(fallbackMethod = "selectUserByIdFall")
    @GetMapping("/wjf/User/GET/{id}/{page}/{size}")
    public User selectUserById(@PathVariable("id") int id, @PathVariable("page") int page, @PathVariable("size") int size){
        page--;
        User user = userAndRoleService.selectUserById(id, page * size, page * size + size);
        return user;
    }

    public User selectUserByIdFall(int id,int page,int size){
        User user = new User();
        user.setUsername("查询的值不存在！！！！！！！");
        return user;
    }

    @GetMapping("/wjf/Role/GET/{id}/{page}/{size}")
    public Role selectRoleById(@PathVariable("id") int id, @PathVariable("page") int page, @PathVariable("size") int size){
        page--;
        Role role = userAndRoleService.selectRoleById(id, page * size, page * size + size);
        return role;
    }
}
