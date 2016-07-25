package cc.zhanyun.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "cc.zhanyun.service")
public class Application {

	public static void main(String[] args) throws Exception {
		new SpringApplication(Application.class).run(args);
	}

}