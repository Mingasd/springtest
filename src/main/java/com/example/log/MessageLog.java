package com.example.log;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessageLog {

    @Pointcut("execution(public void com.example.service.MessageServiceImpl.printMessage())")
    public void sendLog(){
    }

    @Pointcut("bean(*ServiceImpl)")
    public void beanLog(){}

    @After("sendLog()")
    public void after(){
        System.out.println("切点后置通知");
    }

    @Before("sendLog()")
    public void before(JoinPoint joinPoint){
        System.out.println("切点前置通知");
    }

    @Around("sendLog()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("环绕通知前");

        Object proceed = point.proceed();

        System.out.println("环绕通知后");

        return proceed;
    }

    @AfterReturning("sendLog()")
    public void afterReturning(){
        System.out.println("后置返回通知");

    }

    @AfterThrowing("sendLog()")
    public void afterThrowing(){
        System.out.println("后置异常通知");
    }
}
