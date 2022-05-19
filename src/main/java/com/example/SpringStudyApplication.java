package com.example;

import com.example.entity.Email;
import com.example.entity.Message;
import com.example.service.MessageService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringStudyApplication {

    public static void main(String[] args) throws Exception {
//        DefaultListableBeanFactory registry = new DefaultListableBeanFactory();
//        AbstractBeanDefinition messageDefinition
//                        = new RootBeanDefinition(MessageServiceImpl.class, RootBeanDefinition.AUTOWIRE_BY_NAME,true);
//        registry.registerBeanDefinition("messageService",messageDefinition);
//        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
//        mutablePropertyValues.addPropertyValue(new PropertyValue("message", "hello"));
//        messageDefinition.setPropertyValues(mutablePropertyValues);
//        MessageService messageService = (MessageService)registry.getBean("messageService");
//        messageService.printMessage();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        MessageService messageService = (MessageService) context.getBean("messageService");
        messageService.printMessage();
//        Message message = (Message) context.getBean("message");
//        System.out.println(message);
//        Email email = (Email) context.getBean("email");
//        email.setMessage(message);

//        email.sendEmail();
//        System.out.println("================================");
//        Email newEmail = (Email) context.getBean("email");
//        System.out.println(newEmail.getMessageService());
//        System.out.println(context.getBeanFactory());
//        messageService.getBeanContext();
        context.destroy();

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        MessageService messageService = (MessageService) context.getBean("messageServiceImpl");
//        messageService.printMessage();
//        context.destroy();


    }
}
