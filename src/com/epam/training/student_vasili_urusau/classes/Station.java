package com.epam.training.student_vasili_urusau.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Station {
    private static List<Train> trainList;
    private String name;

    public Station(String name) {
        this.name = name;

    }

    public void addTrain(Train train) {
        trainList.add(train);
    }

    public void showTrainsToStationByName(String name) {
        for (Train train : trainList) {
            if (name.equalsIgnoreCase(train.getArrivalStation())){
                System.out.println(train);
            }
        }
    }

    public void showTrainsToStationByNameAfterTime(String name, Date date) {
        for (Train train : trainList) {
            if (name.equalsIgnoreCase(train.getArrivalStation()) && date.compareTo(train.getDepartureTime()) < 0){
                System.out.println(train);
            }
        }
    }

    public void showTrainsToStationByNameSecondClass(String name) {
        for (Train train : trainList) {
            if (name.equalsIgnoreCase(train.getArrivalStation()) && train.getCarriages().contains(Carriage.SECOND_CLASS)){
                System.out.println(train);
            }
        }
    }




    public List<Train> getTrainList() {
        return trainList;
    }

    public void setTrainList(List<Train> trainList) {
        this.trainList = trainList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    static {
        trainList = new ArrayList<>();
        trainList.add(new Train("Brest", new Date(2022,7,21, 21, 30), 123));
        trainList.add(new Train("lida", new Date(2022,7,26, 13, 5), 23));
        trainList.add(new Train("Orsha", new Date(2022,7,15, 8, 36), 167));
        trainList.add(new Train("Gomel", new Date(2022,7,30, 21, 21), 71));
        trainList.get(0).addCarriage(Carriage.FIRST_CLASS);
        trainList.get(0).addCarriage(Carriage.SECOND_CLASS);
        trainList.get(1).addCarriage(Carriage.SECOND_CLASS);
        trainList.get(2).addCarriage(Carriage.SECOND_CLASS);
        trainList.get(3).addCarriage(Carriage.FIRST_CLASS);
    }
}
