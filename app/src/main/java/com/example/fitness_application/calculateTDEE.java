package com.example.fitness_application;



class calculateTDEE {

    public double height,weight;
    public int age;
    public String sex;
    public String activityLevels;
    public double ac;
    public double TDEE;

    /*public calculateTDEE(double height, double weight, int age, String sex, String activityLevels) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.sex = sex;
        this.activityLevels = activityLevels;
    }*/

    public calculateTDEE() {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.sex = sex;
        this.activityLevels = activityLevels;
        //this does nothing
    }

    public double getHeight() {

        return height;
    }

    public void setHeight(double height) {
        try{
            if(height >= 220)
            {
                System.out.println("Please enter a valid value");
            }
            else{
                this.height = height;
            }

        }catch (NullPointerException e)
        {
            System.out.println("Please enter a value");
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getActivityLevels() {
        return activityLevels;
    }

    public void setActivityLevels(String activityLevels)
    {
        this.activityLevels = activityLevels;
    }
    public void setTDEE(double height, double weight, int age, String sex, String activityLevels)
    {

        if (activityLevels.equals("little/no exercise"))
        {

            ac = 1.2;
        }
        else if (activityLevels.equals("light exercise") )
        {
            ac = 1.375;
        }
        else if(activityLevels.equals("moderate") )
        {
            ac = 1.55;
        }
        else if(activityLevels.equals("heavy") )
        {
            ac = 1.725;
        }
        else if(activityLevels.equals( "extreme"))
        {
            ac = 1.9;
        }

        if (sex.equals("F"))
        {
            TDEE= (655 + (9.6*weight)+(1.8*height)-(4.7*age))* ac;
        }
        else if (sex.equals("M"))
        {
            TDEE = (66+(13.7*weight)+(5*height)-(6.8*age))*ac;
        }
    }

    public double getTDEE()

    {
        return TDEE;
    }

}



