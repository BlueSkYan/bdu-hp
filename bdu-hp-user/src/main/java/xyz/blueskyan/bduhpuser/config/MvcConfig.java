package xyz.blueskyan.bduhpuser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.blueskyan.bduhpuser.interceptor.LoginInterceptor;

/**
 * @author Shijie Yan
 * @date 2023/2/13
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/user/login","/user/register", "/userInfo/upload",
                        "/xuqiu/list","/xuqiu/toDel", "/forAdmin/**", "/xuqiuType/**");
    }
}
