package com.saeed.springlogbackappender;

import org.springframework.stereotype.Service;

@Service
public class Notifier {

    public String notify(String message) {
        System.out.println("----- NOTIFY ----- " + message);
        return "notified "+message;
    }
}
