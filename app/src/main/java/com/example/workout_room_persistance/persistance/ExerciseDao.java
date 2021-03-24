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

import java.util.List;

@Dao
public interface ExerciseDao {

    @Insert
    long[] insertExercise(Exercise... exercise);

    @Query("SELECT * FROM exercises")
    LiveData<List<Exercise>> getAllData();

    @Delete
    int delete(Exercise... exercise);

    @Update
    int update(Exercise... exercise);

//    @Query("DELETE FROM exercises")
//    public void delete();


}
