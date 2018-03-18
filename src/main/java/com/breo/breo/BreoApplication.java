package com.breo.breo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.breo"})
public class BreoApplication {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(BreoApplication.class, args);
    System.out.println("Contains A  " + context.containsBeanDefinition("config"));
  }
}
