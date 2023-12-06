package com.json.test.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Scheduler {
@Autowired
SchedulerTask task;
    @Scheduled(initialDelay = 2*1000,fixedDelay = 3*1000)
    public void executeTaskSave () throws JsonProcessingException {
    task.executeSave();
    }
    @Scheduled(initialDelay = 10*1000,fixedDelay = 10*1000)
    public void executeTaskWrite () throws IOException {
        task.executeWrite();
    }
}
