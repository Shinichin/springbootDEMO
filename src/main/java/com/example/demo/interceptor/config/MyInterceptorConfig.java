//package com.example.demo.interceptor.config;
//
//import com.example.demo.interceptor.MyInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
////配置拦截器
//@Configuration
//public class MyInterceptorConfig extends WebMvcConfigurationSupport {
//
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
////        添加自定义的拦截器
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");//拦截所有 /Interceptor 开头的 url 请求
//        super.addInterceptors(registry);
//    }
//    /**
//     * 用来指定静态资源不被拦截，否则继承WebMvcConfigurationSupport这种方式会导致静态资源无法直接访问
//     * @param registry
//     */
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//        super.addResourceHandlers(registry);
//    }
//}
////接实现 WebMvcConfigurer 接口，然后重写 addInterceptors 方法，将自定义的拦截器添加进去即可
////@Configuration
////public class MyInterceptorConfig implements WebMvcConfigurer {
////    @Override
////    public void addInterceptors(InterceptorRegistry registry) {
////        // 实现WebMvcConfigurer不会导致静态资源被拦截
////        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
////    }
////}
