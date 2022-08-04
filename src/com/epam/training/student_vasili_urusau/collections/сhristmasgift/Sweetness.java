package com.epam.training.student_vasili_urusau.collections.сhristmasgift;

public abstract class Sweetness {
    private Integer weight;
    private String name;
    private String form;

    public Sweetness(Integer weight, String name, String form) {
        this.weight = weight;
        this.name = name;
        this.form = form;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public String toString() {
        return "Sweetness{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                ", form='" + form + '\'' +
                '}';
    }
}
