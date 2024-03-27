package online.gladikov.laboratory.simple_web.config;

import online.gladikov.laboratory.simple_web.bean.BeanDependencyOne;
import online.gladikov.laboratory.simple_web.bean.BeanDependencyTwo;
import online.gladikov.laboratory.simple_web.bean.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    BeanDependencyOne beanDependencyOne(){
        return new BeanDependencyOne ();
    }

    @Bean
    BeanDependencyTwo beanDependencyTwo(){
        return new BeanDependencyTwo ();
    }



}
