package com.epam.training.student_vasili_urusau.collections.сhristmasgift;

public class SweetMain {
    public static void main(String[] args) {
        Gift gift = new Gift();
        gift.getWeightAll();
        System.out.println("--------------------");
        gift.sortByWeight();
        System.out.println("--------------------");
        gift.findBySugar(7,12);
    }
}
