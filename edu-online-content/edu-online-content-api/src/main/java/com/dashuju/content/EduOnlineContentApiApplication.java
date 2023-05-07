package com.dashuju.content;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.dashuju.content", "com.dashuju.messagesdk"})
@EnableSwagger2Doc
//@ComponentScan("com.dashuju.messagesdk.mapper")
@EnableFeignClients(basePackages={"com.dashuju.content.feignclient"})
public class EduOnlineContentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduOnlineContentApiApplication.class, args);
	}

}
