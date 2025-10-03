package org.example.converter;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class MyConverter extends MessageConverter {

    @Override
    public String convert(ILoggingEvent event) {
        System.out.println("messsage--->: " + event.getMessage());
        return "messsage--->: " + event.getMessage();
    }
}
