package com.example.workout_room_persistance.persistance;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.workout_room_persistance.model.Exercise;
import com.example.workout_room_persistance.model.Workout;

@Database(entities = {Exercise.class}, version=1)
public abstract class ExerciseDatabase extends RoomDatabase {
   public static final String DATABASE_NAME = "exercise_db";

   private static ExerciseDatabase instance;

   static ExerciseDatabase getInstance(final Context context){
       if(instance == null)
           instance = Room.databaseBuilder(
                   context.getApplicationContext(),
                   ExerciseDatabase.class,
                   DATABASE_NAME
           ).build();
       return instance;
    }

    public abstract ExerciseDao getExerciseDao();

}
