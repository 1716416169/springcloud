package cn.wjf.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClient8021 {
    public static void main(String[] args){
        SpringApplication.run(EurekaClient8021.class,args);
    }
}
