package cn.wjf.spring.service;

import cn.wjf.spring.service.fall.FeignInterfaceFall;
import entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@FeignClient(name = "EUREKA-SERVICE",fallback = FeignInterfaceFall.class)
public interface FeignInterface {

    @RequestMapping(method = RequestMethod.GET,value = "/wjf/User/GET/{id}/{page}/{size}")
    public User selectUserById(@PathVariable("id") int id,@PathVariable("page") int page,@PathVariable("size") int size);
}

