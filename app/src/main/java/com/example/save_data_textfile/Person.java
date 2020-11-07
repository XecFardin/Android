package com.example.save_data_textfile;

public class Person
{
    private  String name;
    private  String  Surname;

    public Person(String name, String surname) {
        this.name = name;
        Surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }
}
