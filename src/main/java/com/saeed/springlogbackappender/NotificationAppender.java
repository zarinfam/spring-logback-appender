package com.saeed.springlogbackappender;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class NotificationAppender extends AppenderBase<ILoggingEvent> implements SmartLifecycle {

    private final Notifier notifier;

    public NotificationAppender(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    protected void append(ILoggingEvent loggingEvent) {
        notifier.notify(loggingEvent.getFormattedMessage());
    }

    @Override
    public boolean isRunning() {
        return isStarted();
    }

    @Override
    public void start() {
        super.start();
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger(Logger.ROOT_LOGGER_NAME);
        AppenderDelegator<ILoggingEvent> delegate = (AppenderDelegator<ILoggingEvent>) rootLogger.getAppender("DELEGATOR");
        delegate.setDelegateAndReplayBuffer(this);
    }
}
