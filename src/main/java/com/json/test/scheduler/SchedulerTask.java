package com.json.test.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.json.test.service.JsonbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SchedulerTask {
    @Autowired
    JsonbService service;
    public void executeSave() throws JsonProcessingException {
        System.out.println("task execute save start");
        service.saveJsonB();
        System.out.println("task execute save end");
    }

    public void executeWrite() throws IOException {
        System.out.println("task execute write start");
        service.sendCSV2();
        System.out.println("task execute write end");
    }
}
