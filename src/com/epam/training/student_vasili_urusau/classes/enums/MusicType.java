package com.epam.training.student_vasili_urusau.classes.enums;

public enum MusicType {
    ROCK("rock"), POP("pop"), CLASSIC, JAZZ("jazz");
    private String realName;

    private MusicType(){
//        System.out.println(this.name() + " " + this.ordinal());
    }

    MusicType(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void info(){
        switch (this){
            case POP:
                System.out.println("this is " + realName);
                break;
            case ROCK:
                System.out.println("this is " + realName);
                break;
            case CLASSIC:
                System.out.println("this is " + realName);
                break;
            case JAZZ:
                System.out.println("this is" + realName);
                break;
            default:
                System.out.println("no no no");
                break;
        }
    }
}
