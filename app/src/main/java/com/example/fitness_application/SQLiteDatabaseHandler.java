package com.example.fitness_application;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ExerciseDB";
    private static final String TABLE_NAME = "Exercises";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CALORIESBURNT = "caloriesBurnt";
    private static final String KEY_DURATION = "duration";
    private static final String[] COLUMNS = { KEY_ID, KEY_NAME, KEY_CALORIESBURNT,
            KEY_DURATION };

    public SQLiteDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATION_TABLE = "CREATE TABLE Exercises ( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "name TEXT, "
                + "position TEXT, " + "height INTEGER )";

        db.execSQL(CREATION_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // you can implement here migration process
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    public void deleteOne(ExerciseList exercise) {
        // Get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id = ?", new String[] { String.valueOf(exercise.getId()) });
        db.close();
    }

    public ExerciseList getExercise(int id) {
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

        ExerciseList exercise = new ExerciseList();
        exercise.setId(Integer.parseInt(cursor.getString(0)));
        exercise.setName(cursor.getString(1));
        exercise.setCaloriesBurnt(cursor.getString(2));
        exercise.setDuration(Integer.parseInt(cursor.getString(3)));

            return exercise;
    }

    public List<ExerciseList> allExercises() {

        List<ExerciseList> exerciseList = new LinkedList<ExerciseList>();
        String query = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ExerciseList exercise= null;

        if (cursor.moveToFirst()) {
            do {
                exercise = new ExerciseList();
                exercise.setId(Integer.parseInt(cursor.getString(0)));
                exercise.setName(cursor.getString(1));
                exercise.setCaloriesBurnt(cursor.getString(2));
                exercise.setDuration(Integer.parseInt(cursor.getString(3)));
                exerciseList.add(exercise);
            } while (cursor.moveToNext());
        }

        return exerciseList;
    }

    public void addExercise(ExerciseList exercise) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, exercise.getName());
        values.put(KEY_CALORIESBURNT, exercise.getCaloriesBurnt());
        values.put(KEY_DURATION, exercise.getDuration());
        // insert
        db.insert(TABLE_NAME,null, values);
        db.close();
    }

    public int updateExercise(ExerciseList exercise) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, exercise.getName());
        values.put(KEY_CALORIESBURNT, exercise.getCaloriesBurnt());
        values.put(KEY_DURATION, exercise.getDuration());

        int i = db.update(TABLE_NAME, // table
                values, // column/value
                "id = ?", // selections
                new String[] { String.valueOf(exercise.getId()) });

        db.close();

        return i;
    }

}
















