package com.varun.springactuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Service;

@Service
@Endpoint(id = "demo")
public class DemoActuatorEndpoint {

    @ReadOperation
    public String demo() {
        return "Demo Actuator Endpoint";
    }
}
