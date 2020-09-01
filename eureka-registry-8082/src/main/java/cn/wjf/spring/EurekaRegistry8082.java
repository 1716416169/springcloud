package cn.wjf.spring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaRegistry8082 {
    public static void main(String[] args){
        SpringApplication.run(EurekaRegistry8082.class,args);
    }

}
