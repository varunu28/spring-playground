package com.varun.springmodulith;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class SpringModulithApplicationTests {

    @Test
    void contextLoads() {
        var modules = ApplicationModules.of(SpringModulithApplication.class);
        modules.verify();

        new Documenter(modules)
            .writeIndividualModulesAsPlantUml()
            .writeModulesAsPlantUml();
    }
}
