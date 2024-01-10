package com.heima.utils;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public  final class AgeUtils {
    private AgeUtils() {

    }

    public static int getAge(String brithday, DateTimeFormatter dtf) {
        int age;
        LocalDate parse1 = LocalDate.parse(brithday, dtf);
        LocalDate now = LocalDate.now();
        Period between = Period.between(parse1, now);
        age = between.getYears();
        return age;


    }
}
