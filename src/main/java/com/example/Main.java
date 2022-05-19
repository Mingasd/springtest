package com.example;

import com.example.service.MessageService;
import com.example.service.MessageServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        final MessageService target = new MessageServiceImpl();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MessageServiceImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("前置通知");
                Object invoke = method.invoke(target,objects);
                System.out.println("后置通知");
                return invoke;
            }
        });
        MessageService messageService = (MessageService) enhancer.create();
        messageService.printMessage();
    }
}
