package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;

    // @Qualifier mendefinisikan kelas yang di ambil
    // setter myCoach dengan value Coach baseballCoach
    @Autowired
    public void setCoach(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theAnotherCoach
            ) {
        // mendefinisikan nama kelas
        System.out.println("In Constructor :"+getClass().getSimpleName());
        myCoach= theCoach;
        anotherCoach= theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public  String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
