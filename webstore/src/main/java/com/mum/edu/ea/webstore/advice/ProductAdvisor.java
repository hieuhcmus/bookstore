package com.mum.edu.ea.webstore.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class ProductAdvisor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("execution(public * com.mum.edu.ea.webstore.controller.ProductController.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        StopWatch timer = new StopWatch();
        String methodName = joinPoint.getSignature().getName();
        timer.start();
        Object obj = joinPoint.proceed();
        timer.stop();
        logger.info("ProductController > " + methodName + " method is called. It took " + timer.getTotalTimeSeconds() + " seconds", joinPoint);
        return obj;
    }

}
