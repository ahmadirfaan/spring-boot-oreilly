
package com.irfaan.learningspringoreilly.config;

import com.irfaan.learningspringoreilly.json.Greeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: AppConfig.java, v 0.1 2021‐12‐17 13.39 Ahmad Irfaan Hibatullah Exp $$
 */

@Configuration
public class AppConfig {

    @Bean(name = "helloWorldGreeting")
    public Greeting defaultGreeting() {
        return new Greeting("Hello, World");
    }

    @Bean(name = "whatsUpGreeting")
    public Greeting whatsUpGreeting() {
        return new Greeting("Hi, Whats Up?");
    }
}