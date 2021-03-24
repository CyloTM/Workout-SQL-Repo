package com.example.workout_room_persistance.persistance;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.workout_room_persistance.model.Exercise;
import com.example.workout_room_persistance.model.Workout;
@Database(entities = {Workout.class, Exercise.class}, version=1)
public abstract class WorkoutDatabase extends RoomDatabase {
   public static final String DATABASE_NAME = "workout_db";

   private static com.example.workout_room_persistance.persistance.WorkoutDatabase instance;

   static com.example.workout_room_persistance.persistance.WorkoutDatabase getInstance(final Context context){
       if(instance == null)
           instance = Room.databaseBuilder(
                   context.getApplicationContext(),
                   com.example.workout_room_persistance.persistance.WorkoutDatabase.class,
                   DATABASE_NAME
           ).build();
       return instance;
    }

    public abstract WorkoutDao getWorkoutDao();
    public abstract WorkoutExerciseDao getWorkoutExerciseDao();

}
