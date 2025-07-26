package com.varunu28.springprofiles;

import com.varunu28.springprofiles.properties.SpringProfileProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SpringProfileProperties.class)
public class SpringProfilesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProfilesApplication.class, args);
    }
}
