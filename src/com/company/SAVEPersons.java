package com.company;

import java.util.Date;
import java.util.Timer;

public class SAVEPersons {
    long delay = 5 * 1000;
    LoopTask task = new LoopTask();
    Timer timer = new Timer("BackUp");

    public void start() {
        timer.cancel();
        timer = new Timer("BackUp");
        Date executionDate = new Date();
        timer.scheduleAtFixedRate (task, executionDate, delay);
    }
}
