package com.JakubP.RandomNumberApp.models;

public class NumberModel {
    private String value;
    public int low = 0;
    public int high = 1000;

    public String getValue(){
        return value;
    }

    public void setValue(final String value){
        this.value=value;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }
}
