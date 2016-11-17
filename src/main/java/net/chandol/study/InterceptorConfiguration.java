package net.chandol.study;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object rawHandler) throws Exception {
                HandlerMethod handler = HandlerMethod.class.cast(rawHandler);
                System.out.println("methodName : " + handler.getMethod().getName());
                if (handler.hasMethodAnnotation(Auth.class)) {
                    Auth auth = handler.getMethodAnnotation(Auth.class);
                    System.out.println("auth : " + auth.value());
                }

                return true;
            }
        });
    }
}
