package com.example.service;

import com.example.entity.Message;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class MessageServiceImpl implements MessageService, BeanFactoryAware, InitializingBean, DisposableBean, BeanNameAware {
    private Message message;
    private BeanFactory beanFactory;

    public MessageServiceImpl() {
        System.out.println("无参构造方法");
    }

    public MessageServiceImpl(Message message) {
        this.message = message;
    }

    public void setMessage(Message message) {
        System.out.println("set方法");
        this.message = message;
    }


    public Message getMessage() {
        return message;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    public void printMessage() throws Exception {
        System.out.println(message);
    }

    @Override
    public void getBeanContext() {
        System.out.println(beanFactory);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware，name="+name);
    }

    private void destroyMethod() {
        System.out.println("XML destroy");
    }

    private void initMethod() {
        System.out.println("xml init");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
