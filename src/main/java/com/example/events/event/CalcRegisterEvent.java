package com.example.events.event;

import org.springframework.context.ApplicationEvent;

public class CalcRegisterEvent extends ApplicationEvent {
    private String operationType;
    private double a;
    private double b;

    public CalcRegisterEvent(Object source, String operationType, double a, double b) {
        super(source);
        this.operationType = operationType;
        this.a = a;
        this.b=b;
    }

    public String getOperationType() {
        return operationType;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
}
