package com.epam.training.student_vasili_urusau.sumdigit;

import java.util.*;

public class SumDigit {
    static Map<Integer, Integer> coupleOfNumber(ArrayList<Integer> array, Integer number) {
        Map<Integer, Integer> map = new HashMap<>();
        int leftPosition = 0;
        int rightPosition = 0;
        Collections.sort(array);
        Integer center = number/2;
        Integer middle = binarySearch(array, center);
        if (array.get(middle).equals(number)) {
            if (number % 2 == 0) {
                if ((middle - 1 >= 0 && array.get(middle - 1).equals(array.get(middle)))
                        || (middle + 1 < array.size() && array.get(middle + 1).equals(array.get(middle)))) {
                    map.put(array.get(middle), array.get(middle));
                }
            }
            while (middle < array.size() - 1 && array.get(middle + 1).equals(array.get(middle))) {
                middle++;
            }
            if (middle != array.size() - 1) {
                leftPosition = middle;
                rightPosition = middle + 1;
                checkSum(leftPosition, rightPosition, map, number, array);
            }
        } else {
            if (center > array.get(middle)) {
                if (middle != array.size() - 1) {
                    leftPosition = middle;
                    rightPosition = middle + 1;
                    checkSum(leftPosition, rightPosition, map, number, array);
                }
            } else {
                if (middle != 0) {
                    rightPosition = middle;
                    leftPosition = middle - 1;
                    checkSum(leftPosition, rightPosition, map, number, array);
                }
            }
        }

    return map;
    }

    private static void checkSum(int leftPosition, int rightPosition, Map<Integer,Integer> map,
                                 Integer number, ArrayList<Integer> array) {
        while (leftPosition >= 0 && rightPosition < array.size()) {
            while (leftPosition > 0 && array.get(leftPosition - 1).equals(array.get(leftPosition))) {
                leftPosition--;
            }
            while (rightPosition < (array.size() - 1) && array.get(rightPosition + 1).equals(array.get(rightPosition))) {
                rightPosition++;
            }
            if (array.get(leftPosition) + array.get(rightPosition) == number) {
                map.put(array.get(leftPosition), array.get(rightPosition));
                leftPosition--;
                rightPosition++;
            } else {
                if (array.get(leftPosition) + array.get(rightPosition) > number) {
                    leftPosition--;
                } else {
                    rightPosition++;
                }
            }
        }
    }
    private static Integer binarySearch(ArrayList<Integer> array, Integer number) {
         int leftBorder = 0;
         int rightBorder = array.size() - 1;
         int middle = 0;
        while (leftBorder <= rightBorder) {
            middle = (leftBorder + rightBorder)/2;
            if (number.equals(array.get(middle))) {
                return middle;
            }
            if (number.compareTo(array.get(middle)) > 0) {
                leftBorder = middle + 1;
            } else {
                rightBorder = middle - 1;
            }
        }
        return middle;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random(10);
        for (int i = 0; i < 19; i++) {
            arrayList.add(random.nextInt(-20, 20));
        }

        System.out.println(arrayList);
//        int number = random.nextInt(5);
//        System.out.println(50);
        Map<Integer, Integer> result = coupleOfNumber(arrayList, 17);
        System.out.println(arrayList);
        System.out.println(result);
        System.out.println(result.size());
    }
}
