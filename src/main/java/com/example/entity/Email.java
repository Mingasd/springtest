package com.example.entity;

import org.springframework.stereotype.Service;

@Service
public class Email {
//    @Autowired
    private Message message;

//    public void setMessageService(MessageService messageService) {
//        this.message = message;
//    }
//
//    public MessageService getMessageService() {
//        return messageService;
//    }

    public void  sendEmail() throws Exception {
        System.out.println("发送电子邮件，邮件信息：" + message.getMessage());
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
