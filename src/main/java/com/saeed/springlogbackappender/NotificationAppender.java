package com.saeed.springlogbackappender;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import jakarta.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NotificationAppender extends AppenderBase<ILoggingEvent> {

    private final Notifier notifier;

    public NotificationAppender(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    protected void append(ILoggingEvent loggingEvent) {
        notifier.notify(loggingEvent.getFormattedMessage());
    }

    @PostConstruct
    public void init() {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger(Logger.ROOT_LOGGER_NAME);
        rootLogger.addAppender(this);
        setContext(context);
        start();
    }
}
