package com.saeed.springlogbackappender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class NotificationAppender extends AppenderBase<ILoggingEvent> implements ApplicationContextAware {

    private static Notifier notifier;

    @Override
    protected void append(ILoggingEvent loggingEvent) {
        if (notifier != null)
            notifier.notify(loggingEvent.getFormattedMessage());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        notifier = applicationContext.getAutowireCapableBeanFactory().getBean(Notifier.class);
    }

}
