package com.jh.b1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableAspectJAutoProxy
//@EnableTransactionManagement
@SpringBootApplication
@EnableScheduling
public class Boot1Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot1Application.class, args);
	}

}
