package com.varunu28.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class BankTransferAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankTransferAspect.class);

    /**
     * Advice that wraps around the bank transfer method to log entry and exit points. Here we are advising the
     * transfer method of the BankService class by logging messages before and after its execution.
     * @param pjp The proceeding join point representing the method being advised
     * @throws Throwable if the advised method throws any exception
     */
    @Around("execution(* com.varunu28.springaop.service.BankService.transfer(..))" )
    public void bankTransferPointcut(ProceedingJoinPoint pjp) throws Throwable {
        LOGGER.info("Enter BankTransferAspect");
        pjp.proceed();
        LOGGER.info("Exit BankTransferAspect");
    }
}
