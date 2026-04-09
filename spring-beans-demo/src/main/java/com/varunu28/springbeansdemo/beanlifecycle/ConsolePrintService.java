package com.varunu28.springbeansdemo.beanlifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Qualifier("consolePrintService")
public class ConsolePrintService implements PrinterService {
    @Override
    public void invokePrint(String message) {
        System.out.println("ConsolePrintService: " + message);
    }

    /**
     * {@link PostConstruct} is also not called automatically for prototype beans. Spring creates instances of
     * prototype beans when they are used.
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("ConsolePrintService@PostConstruct");
    }

    /**
     * As the bean is a prototype bean, Spring doesn't manage the destruction of this bean as Spring lifecycle
     * doesn't have a reference of prototype beans post creation so it cannot invoke the {@link PreDestroy} method.
     */
    @PreDestroy
    public void destroy() {
        System.out.println("ConsolePrintService destroyed");
    }
}
