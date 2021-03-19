package com.example.workout_room_persistance.persistance;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.workout_room_persistance.async.ExerciseDeleteAsyncTask;
import com.example.workout_room_persistance.model.Exercise;

import java.util.List;

public class ExerciseRepository {

    private ExerciseDatabase mExerciseDatabase;

    public ExerciseRepository(Context context) {
        mExerciseDatabase = ExerciseDatabase.getInstance(context);
    }

    public void insertExerciseTask(Exercise exercise){
        new ExerciseDeleteAsyncTask(mExerciseDatabase.getExerciseDao()).execute(exercise);

    }

    public void updateExercise(Exercise exercise){
        new ExerciseDeleteAsyncTask(mExerciseDatabase.getExerciseDao()).execute(exercise);

    }

    public LiveData<List<Exercise>> retrieveExerciseTask(){
        return mExerciseDatabase.getExerciseDao().getAllData();
    }

    public void deleteExercise(Exercise exercise){
        new ExerciseDeleteAsyncTask(mExerciseDatabase.getExerciseDao()).execute(exercise);

    }
}
