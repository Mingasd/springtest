package com.example.service;

import com.example.entity.Message;
import org.springframework.beans.factory.FactoryBean;

public class MessageFactoryBean implements FactoryBean<Message> {
    Message message = new Message("nothing important.");
    @Override
    public Message getObject() throws Exception {
        return message;
    }

    @Override
    public Class<?> getObjectType() {
        return Message.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
