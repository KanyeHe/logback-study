package org.example.event;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.LoggerContextVO;
import org.slf4j.Marker;

import java.util.Map;

public class WrapperedLoggingEvent implements ILoggingEvent {

    private ILoggingEvent originalEvent;
    private String modifiedMessage;

    public WrapperedLoggingEvent(ILoggingEvent originalEvent, String modifiedMessage) {
        this.originalEvent = originalEvent;
        this.modifiedMessage = modifiedMessage;
    }

    @Override
    public String getThreadName() {
        return originalEvent.getThreadName();
    }

    @Override
    public Level getLevel() {
        return originalEvent.getLevel();
    }

    @Override
    public String getMessage() {
        return originalEvent.getMessage();
    }

    @Override
    public Object[] getArgumentArray() {
        return originalEvent.getArgumentArray();
    }

    @Override
    public String getFormattedMessage() {
        return modifiedMessage != null ? modifiedMessage : originalEvent.getFormattedMessage();
    }

    @Override
    public String getLoggerName() {
        return originalEvent.getLoggerName();
    }

    @Override
    public LoggerContextVO getLoggerContextVO() {
        return originalEvent.getLoggerContextVO();
    }

    @Override
    public IThrowableProxy getThrowableProxy() {
        return originalEvent.getThrowableProxy();
    }

    @Override
    public StackTraceElement[] getCallerData() {
        return originalEvent.getCallerData();
    }

    @Override
    public boolean hasCallerData() {
        return originalEvent.hasCallerData();
    }

    @Override
    public Marker getMarker() {
        return originalEvent.getMarker();
    }

    @Override
    public Map<String, String> getMDCPropertyMap() {
        return originalEvent.getMDCPropertyMap();
    }

    @Override
    public Map<String, String> getMdc() {
        return originalEvent.getMdc();
    }

    @Override
    public long getTimeStamp() {
        return originalEvent.getTimeStamp();
    }

    @Override
    public void prepareForDeferredProcessing() {
        originalEvent.prepareForDeferredProcessing();
    }
}
