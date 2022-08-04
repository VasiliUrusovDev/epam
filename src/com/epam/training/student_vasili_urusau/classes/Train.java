package com.epam.training.student_vasili_urusau.classes;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Train {
    private String arrivalStation;
    private Date departureTime;
    private Integer numberTrain;
    private List<Carriage> carriages;

    public Train(String arrivalStation, Date departureTime, Integer numberTrain) {
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.numberTrain = numberTrain;
        carriages = new LinkedList<>();
    }

    public void addCarriage(Carriage carriage) {
        carriages.add(carriage);
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(List<Carriage> carriages) {
        this.carriages = carriages;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getNumberTrain() {
        return numberTrain;
    }

    public void setNumberTrain(Integer numberTrain) {
        this.numberTrain = numberTrain;
    }

    @Override
    public String toString() {
        return "Train{" +
                "arrivalStation='" + arrivalStation + '\'' +
                ", departureTime=" + departureTime +
                ", numberTrain=" + numberTrain +
                '}';
    }
}
