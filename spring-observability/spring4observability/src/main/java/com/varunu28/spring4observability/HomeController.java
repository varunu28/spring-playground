package com.varunu28.spring4observability;

import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @GetMapping
    @Observed(name = "home.count")
    public String home() {
        LOG.info("home endpoint called");
        return "home endpoint";
    }

    @GetMapping("/greet/{name}")
    @Observed(name = "greeting.count")
    public String greeting(@PathVariable String name) {
        LOG.info("greeting endpoint called for {}", name);
        work();
        return "Hello " + name;
    }

    @GetMapping("/slow")
    @Observed(name = "slow.count")
    public String slow() throws InterruptedException {
        LOG.info("Starting slow endpoint call");
        Thread.sleep(500);
        LOG.info("Finishing slow endpoint call");
        return "Done";
    }

    private void work() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
