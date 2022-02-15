package com.annot;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages="com")
public class MyConfig {
	@Bean(name="p1")
	public Product createProduct() {
		return new Product(23,"My Prod");
	}
}
