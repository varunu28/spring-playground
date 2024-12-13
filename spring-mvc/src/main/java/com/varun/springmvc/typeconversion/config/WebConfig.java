package com.varun.springmvc.typeconversion.config;

import com.varun.springmvc.typeconversion.converter.NestedInputConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final NestedInputConverter nestedInputConverter;

    public WebConfig(NestedInputConverter nestedInputConverter) {
        this.nestedInputConverter = nestedInputConverter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(nestedInputConverter);
    }
}