package online.gladikov.laboratory.simple_web.config;


import online.gladikov.laboratory.simple_web.filter.ByeFilter;
import online.gladikov.laboratory.simple_web.filter.RequestResponseLoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

public class FilterConfig {
    @Bean
    public FilterRegistrationBean<ByeFilter> loggingFilter() {
        FilterRegistrationBean<ByeFilter> registrationBean
            = new FilterRegistrationBean<> ();

        registrationBean.setFilter (new ByeFilter ());
        registrationBean.addUrlPatterns ("/bey/*");
        registrationBean.setOrder (2);

        return registrationBean;
    }

}