package cn.wjf.spring.controller;

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
    RestTemplate restTemplate;

    @Autowired
    EurekaDiscoveryClient eurekaDiscoveryClient;

    @GetMapping("/client/8021/GET/{id}/{first}/{last}")
    public User selectUserById(@PathVariable("id") int id, @PathVariable("first") int first, @PathVariable("last") int last){
        HashMap<String, Integer> stringStringHashMap = new HashMap<String, Integer>();
        stringStringHashMap.put("id",id);
        stringStringHashMap.put("first",first);
        stringStringHashMap.put("last",last);
        //User eureka_service_8011 = restTemplate.getForObject("http://EUREKA-SERVICE-8011/wjf/User/GET", User.class, stringStringHashMap);
        User eureka_service_8011 = restTemplate.getForObject("http://EUREKA-SERVICE-8011/wjf/User/GET/1/1/3", User.class );
        System.out.println(eureka_service_8011.toString());
        return eureka_service_8011;
    }

    @GetMapping("/getService")
    public void getService(){
        List<String> services = eurekaDiscoveryClient.getServices();
        for(Object o:services){
            System.out.println(o);
        }
    }

}
