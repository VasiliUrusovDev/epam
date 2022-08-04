package com.epam.training.student_vasili_urusau.thread.options;

import java.util.concurrent.TimeUnit;

public class Runway {

    private int number;

    public Runway(int number) {
        this.number = number;
    }

    public void airplaneTakeRunway() throws InterruptedException {
        System.out.println("Airplane " + Thread.currentThread().getName() + " take runway number " + number);
//        TimeUnit.SECONDS.sleep(1);
    }

    public void airplanePickUpSpeed() throws InterruptedException {
        System.out.println("Airplane " + Thread.currentThread().getName() + " start to pick up speed on runway number " + number);
//        TimeUnit.SECONDS.sleep(1);
    }

    public void thePlaneTookOff() throws InterruptedException {
        System.out.println("Airplane " + Thread.currentThread().getName() + " took off from runway number " + number);
//        TimeUnit.SECONDS.sleep(1);
    }

    public void runwayIsClear() {
        System.out.println("Runway number " + number + " is clear");
    }
}
