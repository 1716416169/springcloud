package cn.wjf.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudConfig8888 {
    public static void main(String[] args){
        SpringApplication.run(CloudConfig8888.class,args);
    }

}
