package com.nhn.academy.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.nhn.academy")
@EnableAspectJAutoProxy
public class JavaConfig {
}
