package org.example.config;


import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import lombok.extern.slf4j.Slf4j;
import org.example.util.JacksonObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * 配置类，注册web层相关组件
 */
@Configuration
@Slf4j
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class Swagger2Configuration {

    /**
     * 通过knife4j生成接口文档
     * @return
     */
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("1.0")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("org.example"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("hcy-demo API文档")
                .description("hcy-demo API文档")
                .version("1.0")
                .build();
    }

    /**
     * 设置静态资源映射
     * @param registry
     */
    // protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    //     registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
    //     registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    // }

    /**
     * 扩展Spring MVC框架的消息转化器
     *
     * @param converters
     */
    // @Override
    // public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    //     //创建一个消息转换器对象
    //     MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    //     //需要为消息转换器设置一个对象转换器，对象转换器可以将Java对象序列化为json数据
    //     converter.setObjectMapper(new JacksonObjectMapper());
    //     //将自己的消息转化器加入容器中
    //     converters.add(0, converter);
    // }

}
