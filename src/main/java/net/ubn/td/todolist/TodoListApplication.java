package net.ubn.td.todolist;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TodoListApplication {

	public static void main(String[] args) {

//		SpringApplication.run(TodoListApplication.class, args);
		new SpringApplicationBuilder(TodoListApplication.class)
				.beanNameGenerator(new CustomGenerator())
				.run(args);
	}

	public static class CustomGenerator implements BeanNameGenerator {

		@Override
		public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
			return definition.getBeanClassName();
		}
	}

}
