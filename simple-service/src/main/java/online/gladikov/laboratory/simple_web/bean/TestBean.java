package online.gladikov.laboratory.simple_web.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class TestBean {

    private BeanDependencyOne one;
    private BeanDependencyTwo two;


    public TestBean() {
        System.out.println ("**********NO ARGS CONSTRUCTOR***********");
    }

    @Autowired
    public TestBean( BeanDependencyOne one) {
        System.out.println ("*********ARGS CONSTRUCTOR************");
        this.one=one;
        System.out.println (this.one);
    }

    @Autowired
    public void setTwo(BeanDependencyTwo two){
        System.out.println ("*********SETTER************");
        this.two = two;
        System.out.println (this.two);
    }
    public void setOne(BeanDependencyOne one){
        System.out.println ("*********SETTER************");
        this.one = one;
        System.out.println (this.one);
    }


    @PostConstruct
    void post(){
        System.out.println ("************POST************");
        System.out.println (this.one);
        System.out.println (this.two);
    }

    @PreDestroy
    void destroy(){
        System.out.println ("************DESTROY****************");
        System.out.println (this.one);
        System.out.println (this.two);
    }

}
