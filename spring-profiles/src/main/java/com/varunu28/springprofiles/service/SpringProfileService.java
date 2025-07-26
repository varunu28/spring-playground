package com.varunu28.springprofiles.service;

import com.varunu28.springprofiles.properties.SpringProfileProperties;
import java.util.Arrays;
import org.springframework.stereotype.Service;

@Service
public class SpringProfileService {

    private final SpringProfileProperties springProfileProperties;
    private final CasingService casingService;

    public SpringProfileService(SpringProfileProperties springProfileProperties, CasingService casingService) {
        this.springProfileProperties = springProfileProperties;
        this.casingService = casingService;
    }

    public String getGreeting() {
        return casingService.changeCasing(springProfileProperties.getGreeting());
    }

    public String getDefaultValue() {
        return casingService.changeCasing(springProfileProperties.getDefaultValue());
    }

    public String[] getListValues() {
        return Arrays.stream(springProfileProperties.getListValues())
            .map(casingService::changeCasing)
            .toArray(String[]::new);
    }
}
