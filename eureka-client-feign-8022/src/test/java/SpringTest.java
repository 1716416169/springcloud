import entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
@EnableEurekaClient
public class SpringTest {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    EurekaDiscoveryClient discoveryClient;
    @Test
    public void test3(){
        List<String> services = discoveryClient.getServices();
        for (Object o:services){
            System.out.println(o);
        }
    }

    @Test
    public void test1(){
        User forObject = restTemplate.getForObject("http://localhost:8011/wjf/User/GET/1/1/3", User.class );
        System.out.println(forObject);
    }
}
