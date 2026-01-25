package com.varunu28.consumerservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner
public class ConsumerServiceApplicationTests {

    @StubRunnerPort("producer-service")
    int producerPort;

    @Autowired
    private LoanApplicationService loanApplicationService;

    @BeforeEach
    public void setup() {
        loanApplicationService.setPort(producerPort);
    }

    @Test
    public void shouldBeRejectedDueToAbnormalLoanAmount() {
        String response = loanApplicationService.loanApplication(99999, "1234567890");

        assert (response.contains("FRAUD"));
    }
}
