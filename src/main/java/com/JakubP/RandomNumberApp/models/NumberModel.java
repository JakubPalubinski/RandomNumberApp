package com.JakubP.RandomNumberApp.models;

public class NumberModel {
    private String value;
    public String getValue(){
        return value;
    }
    public void setValue(final String value){
        this.value=value;
    }
    public int low = 0;
    public int high = 1000;
}
