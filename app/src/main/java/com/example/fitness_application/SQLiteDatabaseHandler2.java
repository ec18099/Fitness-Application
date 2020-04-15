package com.example.fitness_application;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class SQLiteDatabaseHandler2 extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MealsDB";
    private static final String TABLE_NAME = "Meals";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_CALORIEINTAKE = "calories";
    private static final String KEY_INGREDIENTS = "ingredients";
    private static final String[] COLUMNS = { KEY_ID, KEY_NAME, KEY_DESCRIPTION,
            KEY_CALORIEINTAKE,KEY_INGREDIENTS };


    public SQLiteDatabaseHandler2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATION_TABLE = "CREATE TABLE Meals ( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "name TEXT, "
                + "descrption TEXT, " + "calories INTEGER," + "ingredients TEXT )" ;

        db.execSQL(CREATION_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // you can implement here migration process
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    public void deleteOne(Meals meal) {
        // Get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id = ?", new String[] { String.valueOf(meal.getId()) });
        db.close();
    }

    public Meals getMeal(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, // a. table
                COLUMNS, // b. column names
                " id = ?", // c. selections
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        if (cursor != null)
            cursor.moveToFirst();

        Meals meal = new Meals();
        meal.setId(Integer.parseInt(cursor.getString(0)));
        meal.setName(cursor.getString(1));
        meal.setDescription(cursor.getString(2));
        meal.setCalorieIntake(Integer.parseInt(cursor.getString(3)));
        meal.setMealIngredients(cursor.getString(4));

        return meal;
    }

    public List<Meals> allMeals() {

        List<Meals> mealList = new LinkedList<Meals>();
        String query = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Meals meal = null;

        if (cursor.moveToFirst()) {
            do {
                meal = new Meals();
                meal.setId(Integer.parseInt(cursor.getString(0)));
                meal.setName(cursor.getString(1));
                meal.setDescription(cursor.getString(2));
                meal.setCalorieIntake(Integer.parseInt(cursor.getString(3)));
                meal.setMealIngredients((cursor.getString(4)));

                mealList.add(meal);
            } while (cursor.moveToNext());
        }

        return mealList;
    }

    public void addMeal(Meals meal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, meal.getName());
        values.put(KEY_DESCRIPTION, meal.getDescription());
        values.put(KEY_CALORIEINTAKE, meal.getCalorieIntake());
        values.put(KEY_INGREDIENTS, meal.getMealIngredients());


        // insert
        db.insert(TABLE_NAME,null, values);
        db.close();
    }

    public int updateMeal(Meals meal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, meal.getName());
        values.put(KEY_DESCRIPTION, meal.getDescription());
        values.put(KEY_CALORIEINTAKE, meal.getCalorieIntake());
        values.put(KEY_INGREDIENTS, meal.getMealIngredients());


        int i = db.update(TABLE_NAME, // table
                values, // column/value
                "id = ?", // selections
                new String[] { String.valueOf(meal.getId()) });

        db.close();

        return i;
    }

}