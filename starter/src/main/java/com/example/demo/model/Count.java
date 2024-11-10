package com.example.demo.model;

public class Count {

    public static int count = 0;
    public static int getCount(){
        return count;
    }
    public static void increment(){
        count++;
    }
    public static void reset() {
        count = 0;
    }

}