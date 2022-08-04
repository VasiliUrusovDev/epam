package com.epam.training.student_vasili_urusau.thread.options;

public class Airplane extends Thread {

    private Airport airport;
    private Runway runway;

    public Airplane(Airport airport) {
        this.airport = airport;
    }

    @Override
    public void run() {
        try {
            runway = airport.getRunway();
            runway.airplaneTakeRunway();
            runway.airplanePickUpSpeed();
            runway.thePlaneTookOff();
            runway.runwayIsClear();
            airport.putClearRunway(runway);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
