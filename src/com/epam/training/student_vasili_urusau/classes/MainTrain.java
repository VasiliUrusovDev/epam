package com.epam.training.student_vasili_urusau.classes;

import java.util.Date;

public class MainTrain {
    public static void main(String[] args) {
        Station station = new Station("Minsk");
        station.showTrainsToStationByName("brest");
        System.out.println("_____________________");
        station.showTrainsToStationByNameSecondClass("orsha");
        System.out.println("_____________________");
        station.showTrainsToStationByNameAfterTime("gomel", new Date(2022, 7, 21));
        System.out.println("_____________________");

    }
}
