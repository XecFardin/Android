package com.example.myapp;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application
{
    public static ArrayList<Car> cars;
    @Override
    public void onCreate() {
        super.onCreate();
        cars=new ArrayList<Car>();
        cars.add(new Car("Volkswagen","Polo","Chuck Norris","98345645666"));
        cars.add(new Car("Nissan","Almera","Perter Griffen","988292945666"));
        cars.add(new Car("Mercedes","E208","Chris Griffen","9834589979"));
        cars.add(new Car("Volkswagen","Polo","Jeniffer Aniston","98990645666"));
        cars.add(new Car("Nissan","Micra","Noland Norris","9909005666"));
    }
}
