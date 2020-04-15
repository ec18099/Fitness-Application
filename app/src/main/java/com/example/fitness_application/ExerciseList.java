package com.example.fitness_application;

public class ExerciseList {

    private String name;
    private int id;
    private String caloriesBurnt;
    private int duration;

    public ExerciseList() {
        //does nothings
    }

    public ExerciseList(int id,String name,String caloriesBurnt,int duration) {
        this.id=id;
        this.name = name;
        this.caloriesBurnt = caloriesBurnt;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaloriesBurnt() {
        return caloriesBurnt;
    }

    public void setCaloriesBurnt(String caloriesBurnt) {
        this.caloriesBurnt = caloriesBurnt;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
