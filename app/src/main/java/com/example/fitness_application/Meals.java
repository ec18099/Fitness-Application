package com.example.fitness_application;
public class Meals {
    private int id;
    private String name;
    private String description;
    private int calorieIntake;
    private String mealIngredients;

    public Meals() {
        //does nothing
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalorieIntake() {
        return calorieIntake;
    }

    public void setCalorieIntake(int calorieIntake) {
        this.calorieIntake = calorieIntake;
    }

    public String getMealIngredients() {
        return mealIngredients;
    }

    public void setMealIngredients(String mealIngredients) {
        this.mealIngredients = mealIngredients;
    }

    public Meals(int id,String name, String description, int calorieIntake, String mealIngredients){
        this.id=id;
        this.name = name;
        this.description = description;
        this.calorieIntake =  calorieIntake;
        this.mealIngredients = mealIngredients;

    }
}
