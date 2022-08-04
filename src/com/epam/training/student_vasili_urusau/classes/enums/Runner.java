package com.epam.training.student_vasili_urusau.classes.enums;

import com.epam.training.student_vasili_urusau.classes.enums.MusicType;

public class Runner {
    public static void main(String[] args) {
        MusicType type = MusicType.CLASSIC;
//        MusicType[] musicTypes = MusicType.values();
//        int random = (int) (Math.random()*4);
//        String name = musicTypes[random].getRealName();
//        String value = "Rock";
//        MusicType typeRock = MusicType.valueOf(value.toUpperCase().trim());
//        MusicType typeError = MusicType.valueOf("Error");
        type.info();
        MusicType type1 = MusicType.ROCK;
        System.out.println(type1.compareTo(type));



    }
}
