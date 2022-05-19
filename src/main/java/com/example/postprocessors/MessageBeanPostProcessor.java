package com.example.postprocessors;

import com.example.service.MessageService;
import com.example.service.MessageServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;

@Component
public class MessageBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MessageServiceImpl){
            System.out.println("postProcessBeforeInitialization");
//            ((MessageServiceImpl) bean).setMessage("world");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MessageService){
            System.out.println("postProcessAfterInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanClass==MessageServiceImpl.class)
            System.out.println("postProcessBeforeInstantiation");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (bean instanceof MessageService)
            System.out.println("postProcessAfterInstantiation");

        return false;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (bean instanceof MessageServiceImpl){
            PropertyValue message = pvs.getPropertyValue("message");
            System.out.println("更改message之前："+message.getValue());
            message.setConvertedValue("love");
            System.out.println("更改message之后："+message.getValue());
        }

        return pvs;
    }
}
