package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		printAllBeans(ctx);
		printProjectBeans(ctx);
	}

	public static void printAllBeans(ApplicationContext ctx) {
		// Get all the beans in the context
		String[] beanNames = ctx.getBeanDefinitionNames();

		// Sort the beans in alphabetical order
		Arrays.sort(beanNames);

		// Print the sorted beans
		System.out.println("Beans in the context:");
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}

	public static void printProjectBeans(ApplicationContext ctx) {
		// Get all the beans in the context
		String[] beanNames = ctx.getBeanDefinitionNames();

		// Sort the beans in alphabetical order
		Arrays.sort(beanNames);

		// Print the sorted beans
		System.out.println("List of project beans provided by Spring Boot:");
		for (String beanName : beanNames) {
			if (ctx.getBean(beanName).getClass().getPackage().getName().startsWith("com.example.demo")) {
				System.out.println(beanName);
			}
		}
	}
}