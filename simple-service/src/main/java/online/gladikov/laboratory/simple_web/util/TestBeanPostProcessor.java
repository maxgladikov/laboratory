package online.gladikov.laboratory.simple_web.util;

import online.gladikov.laboratory.simple_web.bean.BeanDependencyOne;
import online.gladikov.laboratory.simple_web.bean.BeanDependencyTwo;
import online.gladikov.laboratory.simple_web.bean.TestBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class TestBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        TestBean tb;
        if(bean instanceof TestBean) {

            tb = (TestBean) bean;
            System.out.println (tb.getOne ());
            System.out.println (tb.getTwo ());
            tb.setOne (new BeanDependencyOne ("OneBefore"));
            tb.setTwo (new BeanDependencyTwo ("TwoBefore"));
        }
        return bean;
    }
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        TestBean tb;
        if(bean instanceof TestBean) {
            tb = (TestBean) bean;
            System.out.println (tb.getOne ());
            System.out.println (tb.getTwo ());
            tb.setOne (new BeanDependencyOne ("OneAfter"));
            tb.setTwo (new BeanDependencyTwo ("TwoAfter"));
            System.out.println (tb.getOne ());
            System.out.println (tb.getTwo ());
        }
        return bean;
    }
}
