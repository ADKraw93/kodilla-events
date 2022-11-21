package com.example.events.controller;

import com.example.events.event.CalcRegisterEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/calc")
public class CalcController implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @PostMapping(path = "add")
    public void add(@RequestParam double a, @RequestParam double b) {
        double result = a+b;
        System.out.println(a + " + " + b + " = " + result);

        publisher.publishEvent(
                new CalcRegisterEvent(
                        this,
                        "addition",
                        a,
                        b));
    }

    @PostMapping(path = "substract")
    public void substract(@RequestParam double a, @RequestParam double b) {
        double result = a-b;
        System.out.println(a + " - " + b + " = " + result);

        publisher.publishEvent(
                new CalcRegisterEvent(
                        this,
                        "substraction",
                        a,
                        b));
    }

    @PostMapping(path = "multiply")
    public void multiply(@RequestParam double a, @RequestParam double b) {
        double result = a*b;
        System.out.println(a + " x " + b + " = " + result);

        publisher.publishEvent(
                new CalcRegisterEvent(
                        this,
                        "multiplication",
                        a,
                        b));
    }

    @PostMapping(path = "divide")
    public void divide(@RequestParam double a, @RequestParam double b) {
        if(b==0) {
            System.out.println("You cannot divide by 0");
        } else {
            double result = a/b;
            System.out.println(a + " / " + b + " = " + result);
        }

        publisher.publishEvent(
                new CalcRegisterEvent(
                        this,
                        "division",
                        a,
                        b));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
