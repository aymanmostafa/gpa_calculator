package com.ayman.huci;
/**
 * Created by Hamy on 15/09/2015.
 */
public class MySubject {
    private int id;
    private double hours;
    private String name,grade;

    public MySubject()
    {

    }
    public MySubject (int id , String name , double hours , String grade)
    {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.hours = hours;
    }

    public String getGrade() {
        return grade;
    }

    public double getHours() {
        return hours;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
