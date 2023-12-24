package com.nikhil.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
		}


int a = 10;
int b = 20;
System.out.println(a+b);


String name = "Rahul";
System.out.println(name);


}
