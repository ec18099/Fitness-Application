package com.example.fitness_application;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



public class viewMealList extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private SQLiteDatabaseHandler2 db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_meal_list);

        ListView list = (ListView) findViewById(R.id.MList);
        Log.d(TAG, "onCreate: Started");

        HashMap<String,String> names = new HashMap<>();
        db = new SQLiteDatabaseHandler2(this);


        Meals m1 = new Meals();
        m1.setId(1);
        m1.setName("Avocado Toast-");
        m1.setDescription("high protein avocado toast    ");
        m1.setCalorieIntake(200 );
        m1.setMealIngredients(" avocado,egg,wholemeal bread   ");


        Meals m2 = new Meals();
        m2.setId(2);
        m2.setName("Banana & Peanut Butter Milkshake-");
        m2.setDescription("vegan milkshake");
        m2.setCalorieIntake(539);
        m2.setMealIngredients(" almond milk, bananas, peanut butter    ");

        Meals m3 = new Meals();
        m3.setId(3);
        m3.setName("Omelette-");
        m3.setDescription("low calorie omelette");
        m3.setCalorieIntake(148);
        m3.setMealIngredients(" egg whites, tomatoes, onion    ");

        Meals m4 = new Meals();
        m4.setId(4);
        m4.setName("Chicken breast & rice-");
        m4.setDescription("low calorie chicken breast with rice & salad");
        m4.setCalorieIntake(689);
        m4.setMealIngredients(" chicken breast, rice, broccoli    ");

        Meals m5 = new Meals();
        m5.setId(5);
        m5.setName("Shake-");
        m5.setDescription("Post workout shake");
        m5.setCalorieIntake(765);
        m5.setMealIngredients(" oats, protein shake, almond milk   ");

        Meals m6 = new Meals();
        m6.setId(6);
        m6.setName("Smoothie-");
        m6.setDescription("micro nutrient rich smoothie");
        m6.setCalorieIntake(675);
        m6.setMealIngredients(" kale,avocado,lime,ginger,cashews,banana    ");

        Meals m7 = new Meals();
        m7.setId(7);
        m7.setName("Fruit Salad- ");
        m7.setDescription("basic salad");
        m7.setCalorieIntake(227);
        m7.setMealIngredients(" watermelon,strawberries,apple,banana    ");

        Meals m8 = new Meals();
        m8.setId(8);
        m8.setName("Minced beef & rice-");
        m8.setDescription("low calorie minced beef & rice");
        m8.setCalorieIntake(788);
        m8.setMealIngredients(" minced beef,rice, bell pepper    ");

        Meals m9 = new Meals();
        m9.setId(9);
        m9.setName("Ricecake-");
        m9.setDescription("high protein rice cake snack");
        m9.setCalorieIntake(740);
        m9.setMealIngredients(" rice cakes, peanut butter,banana    ");

        Meals m10 = new Meals();
        m10.setId(10);
        m10.setName("Sweet potato fries-");
        m10.setDescription("low calorie sweet potato fries");
        m10.setCalorieIntake(235);
        m10.setMealIngredients(" sweet potatoes,lime    ");

        Meals m11 = new Meals();
        m11.setId(11);
        m11.setName("Smoked Salmon-");
        m11.setDescription("smoked salmon with asparagus");
        m11.setCalorieIntake(400);
        m11.setMealIngredients(" salmon,asparagus,lemon,onion    ");

        Meals m12 = new Meals();
        m12.setId(12);
        m12.setName("Pesto & Kale pasta-");
        m12.setDescription("creamy pesto pasta with kale");
        m12.setCalorieIntake(420);
        m12.setMealIngredients(" pasta,kale,pesto,onions    ");

        Meals m13 = new Meals();
        m13.setId(13);
        m13.setName("Peanut Butter & jam flapjacks-");
        m13.setDescription("low calorie flapjacks");
        m13.setCalorieIntake(399);
        m13.setMealIngredients(" butter,oats,jam,peanut butter    ");

        db.addMeal(m1);
        db.addMeal(m2);
        db.addMeal(m3);
        db.addMeal(m4);
        db.addMeal(m5);
        db.addMeal(m6);
        db.addMeal(m7);
        db.addMeal(m8);
        db.addMeal(m9);
        db.addMeal(m10);
        db.addMeal(m11);
        db.addMeal(m12);
        db.addMeal(m13);


        List<Meals> mealList = db.allMeals();



        names.put(m1.getName() + m1.getDescription() ,  m1.getMealIngredients() + m1.getCalorieIntake()+ " kcal");
        names.put(m2.getName() + m2.getDescription() ,  m2.getMealIngredients() + m2.getCalorieIntake()+ " kcal" );
        names.put(m3.getName() + m3.getDescription() ,  m3.getMealIngredients() +m3.getCalorieIntake()+ " kcal");
        names.put(m4.getName() + m4.getDescription() ,  m4.getMealIngredients() + m4.getCalorieIntake()+ " kcal");
        names.put(m5.getName() + m5.getDescription() , m5.getMealIngredients() + m5.getCalorieIntake()+ " kcal");
        names.put(m6.getName() + m6.getDescription() ,  m6.getMealIngredients() +m6.getCalorieIntake()+ " kcal");
        names.put(m7.getName() + m7.getDescription() ,  m7.getMealIngredients() +m7.getCalorieIntake()+ " kcal");
        names.put(m8.getName() + m8.getDescription() ,  m8.getMealIngredients() +m8.getCalorieIntake()+ " kcal");
        names.put(m9.getName() + m9.getDescription() ,  m9.getMealIngredients() +m9.getCalorieIntake()+ " kcal");
        names.put(m10.getName() + m10.getDescription() ,m10.getMealIngredients() +m10.getCalorieIntake()+ " kcal");
        names.put(m11.getName() + m11.getDescription() ,m11.getMealIngredients() +m11.getCalorieIntake()+ " kcal");
        names.put(m12.getName() + m12.getDescription() ,m12.getMealIngredients() +m12.getCalorieIntake()+ " kcal");
        names.put(m13.getName() + m13.getDescription() ,m13.getMealIngredients() +m13.getCalorieIntake()+ " kcal");




        List<HashMap<String,String>> listItems = new ArrayList<>();

        SimpleAdapter adapter = new SimpleAdapter(this,listItems,R.layout.meallistitems,new String[]{"Name","Description"}
                ,new int[]{R.id.text1,R.id.text2});
        Iterator it = names.entrySet().iterator();

        while (it.hasNext())
        {
            HashMap<String, String> resultsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            resultsMap.put("Name",pair.getKey().toString());
            resultsMap.put("Description",pair.getValue().toString());
            resultsMap.put("Calories",pair.getValue().toString());
            resultsMap.put("Ingredients",pair.getValue().toString());
            listItems.add(resultsMap);


        }


        list.setAdapter(adapter);





    }
}

