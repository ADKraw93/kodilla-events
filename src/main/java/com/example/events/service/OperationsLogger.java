package com.example.events.service;

import com.example.events.event.CalcRegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OperationsLogger implements ApplicationListener<CalcRegisterEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperationsLogger.class);


    @Override
    public void onApplicationEvent(CalcRegisterEvent event) {
        LOGGER.info("Log an operation: " + event.getOperationType() + "; a=" + event.getA() + "; b=" + event.getB());
    }
}
