package com.epam.training.student_vasili_urusau.collections.сhristmasgift;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Gift {
    private List<Sweetness> sweetnessList = new ArrayList<>();

    public void addSweetness(Candy candy) {
        sweetnessList.add(candy);
    }

    public void getWeightAll() {
        Integer weightAll = 0;
        for (Sweetness sweetness : sweetnessList) {
            weightAll += sweetness.getWeight();
        }
        System.out.println("Gift's weight is " + weightAll);
    }

    public void sortByWeight() {
        sweetnessList.stream()
                .sorted(Comparator.comparing(Sweetness::getWeight))
                .forEach(System.out::println);
    }

    public void findBySugar(Integer low, Integer high) {
        sweetnessList.stream()
                .filter(o -> o instanceof Sugar)
                .filter(o -> ((Sugar) o).getSugarWeight() > low && ((Sugar) o).getSugarWeight()<high)
                .forEach(o -> System.out.println(o));

    }

    {
        sweetnessList.add(new Candy(10, "Flutty","Cotton"));
        sweetnessList.add(new Candy(43, "Hershey’s", "chocolate bar"));
        sweetnessList.add(new Candy(42, "Reese’s", "combo"));
        sweetnessList.add(new CandyWithOutSugar(23, "Teddy", "Bear"));
        Candy candy = (Candy) sweetnessList.get(0);
        candy.setSugarWeight(3);
        Candy candy1 = (Candy) sweetnessList.get(1);
        candy1.setSugarWeight(10);
        Candy candy2 = (Candy) sweetnessList.get(2);
        candy2.setSugarWeight(14);

    }


}
