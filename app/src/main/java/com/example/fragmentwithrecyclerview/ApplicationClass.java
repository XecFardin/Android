package com.example.fragmentwithrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application
{
    public static ArrayList<Person> people;
    @Override
    public void onCreate() {
        super.onCreate();
        people = new ArrayList<Person>();
        people.add(new Person("Chuck Norris","9657496706"));
        people.add(new Person("Safwan Shaikh","4750248420"));
        people.add(new Person("Fardin xec","96543446706"));
        people.add(new Person("Nelson xec","9658986706"));
    }
}
