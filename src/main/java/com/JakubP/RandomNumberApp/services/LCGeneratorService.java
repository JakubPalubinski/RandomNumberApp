package com.JakubP.RandomNumberApp.services;

public class LCGeneratorService implements GeneratorService{
    private Integer number = 12071;
    private static LCGeneratorService gen;

    public static LCGeneratorService getGenerator() {
        if(gen==null){
            gen = new LCGeneratorService();
        }
        return gen;
    }

    private LCGeneratorService(){}

    public Integer getRandomNumber(int low, int high, int seed){
        number = Math.abs(low + (Math.abs(seed)+number/127))%(high-low);
        return number;
    }
}
