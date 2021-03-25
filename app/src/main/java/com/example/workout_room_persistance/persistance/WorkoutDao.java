package com.example.workout_room_persistance.persistance;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.workout_room_persistance.model.Exercise;
import com.example.workout_room_persistance.model.Workout;
import com.example.workout_room_persistance.model.WorkoutWithExercises;

import java.util.List;

@Dao
public interface WorkoutDao {

    @Insert
    long[] insertWorkouts(Workout... workouts);

    @Query("SELECT * FROM workouts")
    LiveData<List<Workout>> getAllData();

    @Delete
    int delete(Workout... workouts);

    @Update
    int update(Workout... workouts);

    @Transaction
    @Query("SELECT * FROM workouts")
    LiveData<List<WorkoutWithExercises>> getWorkoutWithExercises();

    @Update
    int update(Exercise... exercise);

    @Insert
    long[] insertExercise(Exercise... exercise);

    @Query("SELECT * FROM exercises")
    LiveData<List<Exercise>> getAll();
}
