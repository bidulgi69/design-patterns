package org.example.singleflightpattern.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RepositoryQueryAop {

    private final Logger _logger = LoggerFactory.getLogger(getClass());

    @Around("execution(* org.example.singleflightpattern.domain.repository.*.*(..))")
    public Object logRepositoryMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } finally {
            _logger.info("Repository method {} has been called.", joinPoint.getSignature().getName());
        }
    }
}
