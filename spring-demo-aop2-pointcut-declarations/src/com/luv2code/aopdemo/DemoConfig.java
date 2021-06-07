package com.luv2code.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy  //this is for spring aop proxy support
@ComponentScan("com.luv2code.aopdemo")
public class DemoConfig {

}
