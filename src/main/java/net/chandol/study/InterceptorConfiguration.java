package net.chandol.study;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccessLoggingInterceptor());
    }

    static class AccessLoggingInterceptor implements HandlerInterceptor {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object rawHandler) throws Exception {

            if(rawHandler.getClass().isAssignableFrom(HandlerMethod.class)){

                HandlerMethod handler = HandlerMethod.class.cast(rawHandler);

                if (handler.hasMethodAnnotation(AccessLogging.class)) {
                    String handlerName = handler.getMethod().getName();
                    String time = LocalDateTime.now().toString();
                    System.out.println(String.format("methodName : %s accessTime : %s", handlerName, time));
                }

            }

            return true;
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        }
    }
}
