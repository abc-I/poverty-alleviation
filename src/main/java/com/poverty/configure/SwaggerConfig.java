package com.poverty.configure;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/4/21 9:39
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Resource
    private TypeResolver typeResolver;

    @Bean
    public Docket petApi() {
        List<Response> responses = new ArrayList<>();
        responses.add(new ResponseBuilder().code("302").description("重定向临时移动。").build());
        responses.add(new ResponseBuilder().code("400").description("错误的请求！").build());
        responses.add(new ResponseBuilder().code("401").description("未通过身份验证！").build());
        responses.add(new ResponseBuilder().code("403").description("拒绝访问！").build());
        responses.add(new ResponseBuilder().code("405").description("禁用方法！").build());
        responses.add(new ResponseBuilder().code("408").description("请求超时！").build());
        responses.add(new ResponseBuilder().code("410").description("已删除!").build());
        responses.add(new ResponseBuilder().code("415").description("不支持的媒体类型！").build());
        responses.add(new ResponseBuilder().code("500").description("服务器内部错误！").build());

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.poverty.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder()
                        // 标题，默认：Api Documentation
                        .title("Swagger Info")
                        // 说明信息
                        .description("Swagger description")
                        // 版本号，默认：1.0
                        .version("project version")
                        // 开发人信息
                        .contact(new Contact("Li", "url", "email"))
                        .license("文档规范")
                        .licenseUrl("url")
                        .build())
                // 给servlet添加映射前缀。
                // 不配置时：host/context-path/api
                // 配置时：host/context/pathMapping/api
                .pathMapping("/")
                // 返回数据时，用String渲染替代LocalDate
                .directModelSubstitute(LocalDate.class, String.class)
                // 响应的通用渲染模型
                .genericModelSubstitutes(ResponseEntity.class)
                // 自定义更多的渲染模型
                .alternateTypeRules(
                        newRule(typeResolver.resolve(DeferredResult.class,
                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                                typeResolver.resolve(WildcardType.class)))
                // 是否使用默认的http响应状态码
                .useDefaultResponseMessages(false)
                .globalResponses(HttpMethod.GET, responses)
                .globalResponses(HttpMethod.POST, responses)
                .globalResponses(HttpMethod.DELETE, responses)
                .globalResponses(HttpMethod.PUT, responses)
                .globalResponses(HttpMethod.OPTIONS, responses)
                .enableUrlTemplating(true);
    }
}