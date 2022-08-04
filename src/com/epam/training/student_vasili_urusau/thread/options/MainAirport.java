package com.epam.training.student_vasili_urusau.thread.options;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainAirport {
    public static void main(String[] args) {
        Airport airport = new Airport();
        List<Airplane> airplaneList = new ArrayList<>();

        for (int i = 0; i < 160; i++) {
            airplaneList.add(new Airplane(airport));
        }
        for (Airplane airplane: airplaneList) {
            airplane.start();
        }

        try {
//            TimeUnit.SECONDS.sleep(1);
            for ( int i = 0; i <3; i++) {
                airport.addNewRunways(13);
//            TimeUnit.SECONDS.sleep(1);
                airport.deleteRunways(8);
//            TimeUnit.SECONDS.sleep(1);
                airport.deleteRunways(3);
                airport.addNewRunways(7);
            }
//            TimeUnit.SECONDS.sleep(3);
//            airport.addNewRunways(13);
//            TimeUnit.SECONDS.sleep(3);
//            airport.deleteRunways(8);
//            TimeUnit.SECONDS.sleep(3);
//            airport.deleteRunways(3);
//            airport.addNewRunways(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
