package com.demo.yeb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ZGB
 * @version 1.0
 * @description: swagger 内部继承了WebMvcConfigurationSupport这个类, 导致自定义的拦截器不会起效
 *               解决办法是重写 addInterceptors 和 addResourceHandlers方法
 * @date 2022/10/21 16:44
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {


	private final TokenInterceptor tokenInterceptor = new TokenInterceptor();

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(tokenInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/static/**","/","/login")
				// swagger-ui
				.excludePathPatterns("/swagger-resources/**", "/webjars/**",
						"/v2/**", "/swagger-ui.html/**","/doc.html");
		super.addInterceptors(registry);
	}
	// 必须添加
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 文档名字和地址,
		registry.addResourceHandler("/doc.html") // 访问路径
				.addResourceLocations("classpath:/META-INF/resources/"); //映射后的真实路径,结尾必须加/
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Bean
	public Docket createResApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.demo.yeb.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("yeb接口文档")
				.description("API")
				.contact(new Contact("ZGB","http://localhost:8080/API.html","xx@qq.com"))
				.version("1.0")
				.build();
	}
}
