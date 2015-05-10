package com.sundl.spring.hello;

/**
 * Created by Sun on 2015/5/9.
 */
public class MessageServiceImpl implements MessageService {
    public String getMessage() {
        return "你好，This is a test message.";
    }
}
