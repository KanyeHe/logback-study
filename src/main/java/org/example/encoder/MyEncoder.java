package org.example.encoder;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;

import java.nio.charset.StandardCharsets;

public class MyEncoder extends PatternLayoutEncoder {

    @Override
    public byte[] encode(ILoggingEvent event) {
        String message = event.getMessage();
        System.out.println("messsage--->: " + message);

        ((LoggingEvent) event).setMessage("messsage--->: " + message);

        return super.encode(event);
    }
}
