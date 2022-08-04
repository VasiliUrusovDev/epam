package com.epam.training.student_vasili_urusau.thread.options;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Airport {
    private boolean order = true;
    private int quantity = 0;
    private int number = 0;
    private Deque<Runway> runways = new LinkedList<>();
    {
        this.runways.add(new Runway(number++));
        this.runways.add(new Runway(number++));
        this.runways.add(new Runway(number++));
        this.runways.add(new Runway(number++));
    }
    public Airport(){}


    public synchronized Runway getRunway() throws InterruptedException {

//        quantity++;
//        System.out.println("quantity " + quantity);
        if (!order||runways.isEmpty()) {
//            System.out.println(Thread.currentThread().getName() + " I go to sleep");
            wait();
//            System.out.println(Thread.currentThread().getName() + " I wake up");

        }
        return runways.remove();
    }


    public synchronized void putClearRunway(Runway runway) {
//        quantity--;
//        System.out.println("quantity " + quantity);
        runways.add(runway);
        if (order) {
            notify();
        } else {
//            System.out.println("amounts runways are ..." + runways.size() + " in airport");
        }

    }
//
//    public void addNewRunway() {
//        runways.add(new Runway(number++));
//    }
//
    public synchronized void addNewRunways(int value) {
//        System.out.println("________________________________");
        for (int i = 0; i < value; i++) {
            runways.add(new Runway(number++));
            notify();
        }
//        System.out.println(runways.size() + "________________________________");
    }

    public void deleteRunways(int value) throws InterruptedException {
//        System.out.println("________________________________");

        order = false;
//        System.out.println("order = " + false);
            TimeUnit.SECONDS.sleep(1);
        while (runways.size() < value) {
            System.out.println("sleep");
            TimeUnit.SECONDS.sleep(1);
        }
        delete(value);

//        order = true;
//        System.out.println("________________________________");
    }

    private synchronized void delete(int value) {
        for (int i = 0; i < value; i++) {
            runways.remove();
            number--;
        }
        if (runways.size() != 0) {
//            System.out.println("start notify");
            int amount = runways.size();
//            System.out.println("amount = " + amount);
            for (int i = 0; i < amount; i++) {
//                System.out.println("notify " + i);
            notify();
            }
        }
        order = true;
//        System.out.println(number);
    }


}
