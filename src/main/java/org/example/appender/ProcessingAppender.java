package org.example.appender;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.AppenderBase;
import org.example.processor.MyProcessor;
import org.slf4j.LoggerFactory;

public class ProcessingAppender extends AppenderBase<ILoggingEvent> {
    private Appender<ILoggingEvent> appenderRef;
    private final MyProcessor processor = new MyProcessor();

    @Override
    public void start() {
        if (appenderRef == null) {
            addError("No delegate appender specified for ProcessingAppender: " + name);
        }
        if (!appenderRef.isStarted()) {
            addError("Delegate appender is not started: " + appenderRef.getName());
            return;
        }
        super.start();
    }

    @Override
    protected void append(ILoggingEvent event) {
        ILoggingEvent loggingEvent = processor.process(event);
        appenderRef.doAppend(loggingEvent);
    }

    public Appender<ILoggingEvent> getDelegateAppender() {
        return appenderRef;
    }

    public void setDelegateAppender(Appender<ILoggingEvent> delegateAppender) {
        this.appenderRef = delegateAppender;
    }
}
