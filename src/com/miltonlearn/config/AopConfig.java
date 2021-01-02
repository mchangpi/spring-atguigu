package com.miltonlearn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.miltonlearn.aop"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {
}
