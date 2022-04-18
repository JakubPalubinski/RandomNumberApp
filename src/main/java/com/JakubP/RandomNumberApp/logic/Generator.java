package com.JakubP.RandomNumberApp.logic;

public class Generator {
    private static Integer number = 12071;

    public static Integer getRandomNumber(int low, int high, int seed){
        number = Math.abs(low + (Math.abs(seed)+number/127))%(high-low);
        return number;
    }
}
