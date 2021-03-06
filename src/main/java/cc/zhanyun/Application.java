package cc.zhanyun;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "cc.zhanyun")
// @EnableDiscoveryClient
public class Application {

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("20480KB");
		factory.setMaxRequestSize("20480KB");
		return factory.createMultipartConfig();
	}

	public static void main(String[] args) throws Exception {
		new SpringApplication(Application.class).run(args);

	}

}