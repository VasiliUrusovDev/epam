package com.epam.training.student_vasili_urusau.collections.сhristmasgift;

public class Candy extends Sweetness implements Sugar{

    private Integer sugarWeight;

    public Candy(Integer weight, String name, String form) {
        super(weight, name, form);
    }

    @Override
    public Integer getSugarWeight() {
        return sugarWeight;
    }

    @Override
    public void setSugarWeight(Integer sugarWeight) {
        this.sugarWeight = sugarWeight;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "sugarWeight=" + sugarWeight +
                '}';
    }
}
