package com.epam.training.student_vasili_urusau.classes;

public enum Carriage {
    FIRST_CLASS(20), SECOND_CLASS(35);
    public int numberOfSeats;

    Carriage(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
