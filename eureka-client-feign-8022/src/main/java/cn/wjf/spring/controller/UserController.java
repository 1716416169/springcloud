package cn.wjf.spring.controller;

import cn.wjf.spring.service.FeignInterface;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    EurekaDiscoveryClient eurekaDiscoveryClient;

    @Autowired
    FeignInterface feignInterface;

    @GetMapping("/client/GET/{id}/{first}/{last}")
    public User selectUserById(@PathVariable("id") int id, @PathVariable("first") int first, @PathVariable("last") int last){
        User user = feignInterface.selectUserById(id, first, last);
        return user;
    }

    @GetMapping("/getService")
    public void getService(){
        List<String> services = eurekaDiscoveryClient.getServices();
        for(Object o:services){
            System.out.println(o);
        }
    }

}
