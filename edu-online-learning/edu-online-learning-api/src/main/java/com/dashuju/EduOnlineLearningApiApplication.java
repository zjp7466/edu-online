package com.dashuju;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages={"com.dashuju.learning.feignclient"})
@EnableSwagger2Doc
public class EduOnlineLearningApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduOnlineLearningApiApplication.class, args);
    }

}
