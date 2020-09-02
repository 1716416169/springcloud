package cn.wjf.spring.service.fall;

import cn.wjf.spring.service.FeignInterface;
import entity.User;
import org.springframework.stereotype.Component;

@Component
public class FeignInterfaceFall implements FeignInterface {
    public User selectUserById(int id, int page, int size) {
        User user = new User();
        user.setUsername("服务器已关闭！！！！！！");
        return user;
    }
}
