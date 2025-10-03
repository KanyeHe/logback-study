package org.example.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class MyFilter extends Filter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent event) {
        System.out.println("filter message --> " + event.getMessage());

        if (event.getMessage().contains("filter")) {
            return FilterReply.DENY;
        }
        return FilterReply.NEUTRAL;
    }
}
