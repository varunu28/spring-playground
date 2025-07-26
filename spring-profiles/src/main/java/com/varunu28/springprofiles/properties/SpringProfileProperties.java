package com.varunu28.springprofiles.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my")
public class SpringProfileProperties {

    @Value("${my.greeting}")
    private String greeting;

    @Value("${my.default}")
    private String defaultValue;

    @Value("${my.list.values}")
    private String[] listValues;

    public String getGreeting() {
        return greeting;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String[] getListValues() {
        return listValues;
    }
}
