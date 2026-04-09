package com.varunu28.springbeansdemo.beanlifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@Qualifier("paperPrintService")
public class PaperPrintService implements PrinterService {
    @Override
    public void invokePrint(String message) {
        System.out.println("PaperPrintService: " + message);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("PaperPrintService: postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("PaperPrintService: preDestroy");
    }
}
