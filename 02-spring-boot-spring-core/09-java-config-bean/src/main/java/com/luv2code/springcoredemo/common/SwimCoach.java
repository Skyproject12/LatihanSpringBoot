package com.luv2code.springcoredemo.common;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("In contstructor" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warmup";
    }
}
