package org.example.processor;

import ch.qos.logback.classic.spi.ILoggingEvent;
import org.example.event.WrapperedLoggingEvent;

public class MyProcessor {

    public ILoggingEvent process(ILoggingEvent event) {
        System.out.println("original message: " + event.getFormattedMessage());

        String  newMessage = "updated message --> " + event.getFormattedMessage();
        return new WrapperedLoggingEvent(event, newMessage);
    }
}
