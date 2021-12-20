package com.irfaan.learningspringoreilly;

import static org.junit.jupiter.api.Assertions.*;

import com.irfaan.learningspringoreilly.config.AppConfig;
import com.irfaan.learningspringoreilly.json.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootTest
class LearningSpringOreillyApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		int count = applicationContext.getBeanDefinitionCount();
		System.out.println("There is : " + count + " bean definition");
		Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
	}

	/**
	 * Sebuah application context atau container yang mengumpulkan bean-bean yang didefinisikan oleh sebuah programmer
	 * sebuah bean/component yang telah ditautkan terhadap suatu class adalah singleton object (yang artinya object
	 * tersebut hanya dibuat sekali dan akan langsung dihancurkan/di destroy dari sebuah memory, jika kita membuat
	 * object lain yang sama maka hal tersebut akan mereferensikan object yang telah dicreate oleh application context,
	 * berbeda halnya seperti di bawah ini sebuah bean telah dibuat 2x dengan object yang berbeda dengan menggunakan
	 * annotasi @Bean selayaknya cek class method :
	 * @see AppConfig#defaultGreeting()
	 * @see AppConfig#whatsUpGreeting()
	 */
	@Test
	void getBeanTwice() {
		Greeting greeting1 = applicationContext.getBean("helloWorldGreeting",Greeting.class);
		Greeting greeting2 = applicationContext.getBean("whatsUpGreeting",Greeting.class);
		assertNotEquals(greeting1, greeting2);
		System.out.println("Greeting 1 : " + greeting1);
		System.out.println("Greeting 2 : " + greeting2);
	}

}
